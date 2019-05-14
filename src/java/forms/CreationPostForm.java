/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import DAO.DAOArticle;
import beans.Article;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class CreationPostForm {
    private static final String TITLE = "title";
    private static final String BODY = "body";
    String result;
      private final Map<String, String> errors = new HashMap<>();
    DAOArticle daoarticle = new DAOArticle();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

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
         
        
        Article post = new Article();
       post.setTitle(title);
       post.setBody(body);
        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de la connexion.";
        } else {
            result += "Échec de la connexion.";
        }
        return post;
    }

       /*
* Ajoute un message correspondant au champ spécifié à la map des
erreurs.
     */
    private void setError(String field, String message) {
        errors.put(field, message);
    }

    /*
* Méthode utilitaire qui retourne null si un champ est vide, et son
contenu
* sinon.
     */
    private static String getParamValue(HttpServletRequest request, String paramKey) {
        String value = request.getParameter(paramKey);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value;
        }
    }
}
