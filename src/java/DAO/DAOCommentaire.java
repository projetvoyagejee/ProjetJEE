/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import beans.Commentaire;
import java.util.List;

/**
 *
 * @author Julien Modena
 */
public class DAOCommentaire extends DAO<Commentaire>{
    //variable par rapport à l'etat du commentaire
    // Quand il est egal a 0 le commentaire est conservé
  private final  int conserver = 0;
  // quand la variable est egal à 1 le commentaire est signalé et peut être supprimé par la suite
  // La base de donnée : les commentaires ont un clé etrangère pour avoir le lien avec les utilisateurs
  private final int signaler = 1;

  
  private final String table = "Commentaire";
    @Override
    public Commentaire find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commentaire create(Commentaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Commentaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commentaire update(Commentaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commentaire> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
