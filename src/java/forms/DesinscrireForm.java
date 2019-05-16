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
     DAOUser daouser = new DAOUser();
     
     
       public User desinscrireUser(HttpServletRequest request) {
       String email = request.getParameter("email");
      String pwd = request.getParameter("password");
      String usename = request.getParameter("name");
      String admin = request.getParameter("admin");
      String eta = request.getParameter("etat");
        // Le bean à retourner
        User user = new User();
        user.setEmail(email);
        user.setPassword(pwd);
        user.setName(usename);
        user.setAdmin(Integer.parseInt(admin));
        user.setEtat(Integer.parseInt(eta));
       User Utilisateur = daouser.retrouverUser(email);
       user = daouser.desinscrire(Utilisateur);
       return user;
       }

}
