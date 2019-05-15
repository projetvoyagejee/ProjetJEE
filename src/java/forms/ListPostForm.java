/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOArticle;
import beans.Article;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class ListPostForm {
     DAOArticle daoarticle = new DAOArticle();

   

    /**
     * Méthode de validation du poste est de creation de celui-ci
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public List<Article> retourList(HttpServletRequest request) {
         List<Article> post = daoarticle.findAll();
       
        return post;
        
    }

}
