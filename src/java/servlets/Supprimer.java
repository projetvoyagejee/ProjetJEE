/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.User;

import forms.SupprimerForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julien Modena
 */
public class Supprimer extends HttpServlet{

    private static final String ATT_USER = "User";
   
    public static final String VIEWADMIN ="/WEB-INF/view/listUser.jsp";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* Préparation de l'objet formulaire */
     SupprimerForm form = new SupprimerForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en résultant
         */
        User user = form.supprimerUser(req);
        
        /* Redirection vers le formulaire de connexion */
       
         req.setAttribute(ATT_USER, user);
        
         
         
         
        this.getServletContext()
                .getRequestDispatcher(VIEWADMIN)
                .forward(req, resp);
       
    }

}
