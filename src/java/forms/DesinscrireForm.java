/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOUser;
import beans.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class DesinscrireForm {
         // quand la variable est egal à 1 l'utilisateur c'est desinscrit et c'est commentaire son toujours actif
  // La base de donnée : les commentaires ont un clé etrangère pour avoir le lien avec les utilisateurs
  private final int desinscrire = 1;
     private static final String ID ="id";
     DAOUser daouser = new DAOUser();
     
     
    
     
       public User desinscrireUser(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter(ID));
        
       User user = daouser.find(id);
           
       User utilisateur = daouser.updateEtat(desinscrire,user);

       
       return utilisateur;
       }

}
