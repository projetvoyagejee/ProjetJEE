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
public class SupprimerForm {
private static final String ID ="id";
     DAOUser daouser = new DAOUser();
     
     // Quand l'etat est egal à 2 l'utilisateur est supprimé et c'est commentaire sont remplacé par un text prédefini
  private final int supprime = 2;
    
     
       public User supprimerUser(HttpServletRequest request) {
       int id = Integer.parseInt(request.getParameter(ID));
        
       User user = daouser.find(id);
           
       User utilisateur = daouser.updateEtat(supprime,user);

       
       return utilisateur;
       }

}
