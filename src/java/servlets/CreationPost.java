/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.Article;
import forms.CreationPostForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julien Modena
 */
public class CreationPost  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CreationPostForm postform = new CreationPostForm();
        /* Traitement de la requête et récupération du bean en résultant */
       Article post = postform.creationArticle(req);
        /* Récupération de la session depuis la requête */
        HttpSession session = req.getSession();
        /*
          * Si aucune erreur de validation n'a eu lieu, alors ajout du bean user
         * à la session, sinon suppression du bean de la session.
         */
//        if (postform.getErrors().isEmpty()) {
//            session.setAttribute(ATT_SESSION_USER, user);
//        } else {
//            session.setAttribute(ATT_SESSION_USER, null);
//        }
//        /* Stockage du formulaire et du bean dans l'objet request */
//        request.setAttribute(ATT_FORM, form);
//        request.setAttribute(ATT_USER, user);
        
    }

        
}
