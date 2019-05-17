/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import DAO.DAOArticle;
import forms.ArticleForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julien Modena
 */
public class Article  extends HttpServlet{
      
     private static final String ATT_POST = "Article";
    public static final String VIEW = "/WEB-INF/view/Article.jsp";
    DAOArticle daoarticle = new DAOArticle();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
      ArticleForm artform = new ArticleForm();
        /* Traitement de la requête et récupération du bean en résultant */
          /* Récupération de la session depuis la requête */
        
         beans.Article post = artform.retourArticle(req);
        System.out.println("l'article du retour article"+post);
        /* Stockage du formulaire et du bean dans l'objet request */
       
        req.setAttribute(ATT_POST, post);
        
        this.getServletContext()
                .getRequestDispatcher(VIEW)
                .forward(req, resp);
    }
    

}
