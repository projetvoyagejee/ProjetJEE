/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOArticle;
import beans.Article;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class CreationPostForm {
    private static final String TITLE = "title";
    private static final String BODY = "body";
    private static final String DATE="date";
   
    DAOArticle daoarticle = new DAOArticle();

   

    /**
     * Méthode de validation du poste est de creation de celui-ci
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public Article creationArticle(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String title = request.getParameter(TITLE);
        String body= request.getParameter(BODY);
        String testdate = request.getParameter(DATE);
        
       
        Article post = new Article();
        
       post.setTitle(title);
       
       post.setBody(body);
       post.setDate(testdate);
       
       daoarticle.create(post);
        return post;
        
    }

}