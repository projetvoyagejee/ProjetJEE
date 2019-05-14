/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien Modena
 */
public class DAOUser extends DAO<User> {

    private final int nonAdmin = 1;
    //variable par rapport à l'etat de l'utilisateur
    // Quand il est egal a 0 il s'agit d'un utilisateur ayant un compte 
  private final  int creation = 0;
  // quand la variable est egal à 1 l'utilisateur c'est desinscrit et c'est commentaire son toujours actif
  // La base de donnée : les commentaires ont un clé etrangère pour avoir le lien avec les utilisateurs
  private final int desinscrire = 1;
  // Quand l'etat est egal à 2 l'utilisateur est supprimé et c'est commentaire sont remplacé par un text prédefini
  private final int supprime = 2;
  
  private final String table = "utilisateur";
 
  @Override
    public User find(Integer id) {
         User retObj = null;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE id_utilisateur=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
            pstmt.setInt(1, id);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();
               
            if (rs.first()) {
                retObj = new User(id,
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                       
                        rs.getInt("admin"),
                         rs.getInt("etat")
                        
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;

    }

    @Override
    public User create(User obj) {
        
       User rtObj = null;
        String sql = "INSERT INTO " + table + " (email, password, username, etat, admin)" + " VALUES (?, ?, ?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, encryptThisString(obj.getPassword()));
            pstmt.setString(3, obj.getName());
            pstmt.setInt(4,creation);
            pstmt.setInt(5, nonAdmin);
            pstmt.executeUpdate();
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.first()) {
                rtObj = this.find(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtObj;
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User update(User obj) {
          User rtObj = null;
        String sql = "UPDATE " + table + " SET "
                + "email = ?,"
                + "password = ?,"
                + "username = ?"
                +"etat = ?"
                +"admin=?"
                + " WHERE id_utilisateur = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, encryptThisString(obj.getPassword()));
            pstmt.setString(3, obj.getName());
            pstmt.setInt(4, obj.getEtat());
           
            pstmt.setInt(5,obj.isAdmin());
             pstmt.setInt(6, obj.getId_User());
            pstmt.executeUpdate();
            //réhydrate l'objet a partir de ces nouvelles données
            rtObj = find(obj.getId_User());

        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rtObj;
    }

   public boolean findLog(String mail, String pwd){
        boolean log = false;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE email=?";
        
         try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
                 pstmt.setString(1, mail);
             // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
                 ResultSet rs = pstmt.executeQuery();
                 if(rs.first())
                 {
                      // recupere le deuxieme parametre de rs est si il est egal à mail va retourner true
                     // donc l'utilisateur existe deja

                      System.out.println("pwd "+encryptThisString(pwd));
                     log = ((mail.equals(rs.getString("email"))) && (encryptThisString(pwd).equalsIgnoreCase(rs.getString("password"))));
                      System.out.println("rs " +rs.getString("password"));
                 }
          
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         // si l'utilisateur n'existe pas retourne false et autorise la creation de l'utilisateur
         System.out.println(log);
        return log;
   }
  
    public boolean findEmail(String mail){
        
        boolean existe = false;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE email=?";
         try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
                 pstmt.setString(1, mail);
             // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
                 ResultSet rs = pstmt.executeQuery();
                 rs.first();
                 // recupere le deuxieme parametre de rs est si il est egal à mail va retourner true 
                 // donc l'utilisateur existe deja 
                existe = (mail.equals(rs.getString(2)));
             
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
         // si l'utilisateur n'existe pas retourne false et autorise la creation de l'utilisateur
         System.out.println(existe);
        return existe;
    }

    
   @Override
    public List<User> findAll() {
        ArrayList<User> retObj = new ArrayList<>();
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                retObj.add(new User(rs.getInt("id_utilisateur"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getInt("admin"),
                        rs.getInt("etat")
                        
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;

    }
    
    
  public static String encryptThisString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
 
}
