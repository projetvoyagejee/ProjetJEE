/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOUser;
import beans.User;
import java.util.List;

/**
 *
 * @author Julien Modena
 */
public class AdminForm {
    DAOUser daouse = new DAOUser();
    
    List<User> listeUtilisateur = daouse.findAll(); 
   
    
    
}
