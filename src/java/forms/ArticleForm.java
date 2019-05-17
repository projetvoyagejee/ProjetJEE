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
public class ArticleForm {
         DAOArticle daoarticle = new DAOArticle();
         private static final String ID ="id";
        
    
    /**
     * Méthode de validation du poste est de creation de celui-ci
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public Article retourArticle(HttpServletRequest request) {
        Article post = null;
        /* Récupération des champs du formulaire */
        if(request==null){
            
        }else{
       int id = Integer.parseInt(request.getParameter(ID));
        post=daoarticle.find(id);
        }
            
        
       
      
       
       
        return post;
        
    }

}
