/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOUser;
import beans.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class ListUserForm {
       DAOUser daouser = new DAOUser();

    
    
    /**
     * Méthode de validation du poste est de creation de celui-ci
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public List<User> retourListInscrit(HttpServletRequest request) {
         List<User> ins = daouser.findAll();
       
        return ins;
        
    }

}
