/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.Article;

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
public class DAOArticle extends DAO<Article>{

     private final String table = "Articles";
     DAOCategorie daocategorie = new DAOCategorie();
    @Override
    public Article find(Integer id) {
           Article retObj = null;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE id_Articles=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
            pstmt.setInt(1, id);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();
               
            if (rs.first()) {
                retObj = new Article(id,
                        rs.getString("title"),
                        rs.getString("body"),
                        rs.getString("img"),
                       rs.getString("date"),
                        rs.getInt("up"),
                        rs.getInt("down")
                
                        
                        
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    @Override
    public Article create(Article obj) {
         
       Article rtObj = null;
        String sql = "INSERT INTO " + table + " (title, body,img, date,up,down)" 
                + " VALUES (?, ?, ?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getBody());
             pstmt.setString(3, null);
            pstmt.setString(4, obj.getDate());
             pstmt.setInt(5, 0);
              pstmt.setInt(6, 0);
             
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
    public void delete(Article obj) {
//             User rtObj = null;
//        String sql = "UPDATE " + table + " SET "
//                + "email = ?,"
//                + "password = ?,"
//                + "username = ?"
//                +"etat = ?"
//                +"admin=?"
//                + " WHERE id_utilisateur = ?";
//        try {
//            PreparedStatement pstmt = connection.prepareStatement(sql);
//            pstmt.setString(1, obj.getEmail());
//            pstmt.setString(2, encryptThisString(obj.getPassword()));
//            pstmt.setString(3, obj.getName());
//            pstmt.setInt(4, obj.getEtat());
//           
//            pstmt.setInt(5,obj.isAdmin());
//             pstmt.setInt(6, obj.getId_User());
//            pstmt.executeUpdate();
//            //réhydrate l'objet a partir de ces nouvelles données
//            rtObj = find(obj.getId_User());
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rtObj;
    }

    @Override
    public Article update(Article obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Article> findAll() {
        ArrayList<Article> retObj = new ArrayList<>();
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                retObj.add(new Article(rs.getInt("id_Articles"),
                        rs.getString("title"),
                        rs.getString("body"),
                        rs.getString("img"),
                        rs.getString("date"),
                        rs.getInt("up"),
                        rs.getInt("down")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;

    }
   
    
   



}
