/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOArticle;
import beans.Article;
import java.util.List;

/**
 *
 * @author Julien Modena
 */
public class ListLikeForm {

DAOArticle daoarticle = new DAOArticle();
List<Article> post = daoarticle.findAll();
         
    

}
