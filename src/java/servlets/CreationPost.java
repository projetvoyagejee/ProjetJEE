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

/**
 *
 * @author Julien Modena
 */
public class CreationPost  extends HttpServlet{

     /* Des constantes */
   
    private static final String ATT_POST = "article";
    public static final String VIEW = "/WEB-INF/view/creationPost.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          /* Préparation de l'objet formulaire */
        CreationPostForm postform = new CreationPostForm();
        /* Traitement de la requête et récupération du bean en résultant */
       Article post = postform.creationArticle(req);
       
        /* Stockage du formulaire et du bean dans l'objet request */
       
        req.setAttribute(ATT_POST, post);
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(req, resp);
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(req, resp);
    }

        
}
