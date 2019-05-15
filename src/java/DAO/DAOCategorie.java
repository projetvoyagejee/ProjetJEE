/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.Categorie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien Modena
 */
public class DAOCategorie extends DAO<Categorie> {
    
    private final String table = "Categorie";
    @Override
    
    public Categorie  find(Integer id) {
        Categorie   retObj = null;
        // faut faire attention aux espaces qui doivent entouré le nom de la table
        String sql = "SELECT * FROM " + table + " WHERE id_categorie=?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // permet de trouver dans la base de données tous les lignes ayant l'id
            pstmt.setInt(1, id);
            // cette ensemble permet de récuperer tous les objets ayant le bon pstmt
            ResultSet rs = pstmt.executeQuery();
               
            if (rs.first()) {
                retObj = new Categorie  (id,
                        rs.getString("categorie")
                        
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retObj;
    }

    @Override
    public Categorie  create(Categorie  obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Categorie obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Categorie  update(Categorie  obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Categorie > findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
