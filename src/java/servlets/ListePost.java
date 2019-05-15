/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import beans.Article;
import forms.ListPostForm;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Julien Modena
 */
public class ListePost  extends HttpServlet{
    private static final String ATT_POST = "listPost";
    public static final String VIEW = "/WEB-INF/view/ListPost.jsp";
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /* Préparation de l'objet formulaire */
       ListPostForm listform = new ListPostForm();
        /* Traitement de la requête et récupération du bean en résultant */
        List<Article> art = listform.retourList(req);
       
        for(Article post : art)
        {
            req.setAttribute(ATT_POST, post);
        }
        /* Stockage du formulaire et du bean dans l'objet request */
       
        
        /* Transmission de la paire d'objets request/response à notre JSP */
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(req, resp);
    }

}
