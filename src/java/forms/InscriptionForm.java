package forms;

import DAO.DAOUser;
import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Herbert Caffarel <herbert.caffarel@cicef.pro>
 */
public class InscriptionForm {

    private static final String EMAIL_FIELD = "email";
    private static final String PASSWORD_FIELD = "password";
    private static final String CONFIRM_FIELD = "confirm";
    private static final String NAME_FIELD = "username";
    DAOUser daouser = new DAOUser();
    private String result;
    private final Map<String, String> errors = new HashMap<>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    /**
     * Méthode de validation du formulaire.
     *
     * @param request La reuête utilisateur
     * @return Un bean user hydraté par les données utilisateur.
     */
    public User inscribeUser(HttpServletRequest request) {
        /* Récupération des champs du formulaire. */
        String email = getParamValue(request, EMAIL_FIELD);
        String password = getParamValue(request, PASSWORD_FIELD);
        String confirm = getParamValue(request, CONFIRM_FIELD);
        String name = getParamValue(request, NAME_FIELD);

        // Le bean à retourner
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);

        try {
            validateEmail(email);
        } catch (Exception e) {
            setError(EMAIL_FIELD, e.getMessage());
        }
        try {
            validatePassword(password, confirm);
        } catch (Exception e) {
            setError(PASSWORD_FIELD, e.getMessage());
        }
        try {
            validateName(name);
        } catch (Exception e) {
            setError(NAME_FIELD, e.getMessage());
        }
        try {
            verifieEmail(email);
            
        }catch(Exception e){
            setError(EMAIL_FIELD, e.getMessage());
        }

        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            
            
            daouser.create(user);
            result = "Succès de l'inscription.";
        } else {
            result = "Échec de l'inscription.";
        }

        // Retourner le bean au code appelant
        return user;
    }

    private void validateEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }   
            
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }
private void verifieEmail(String mail) throws Exception{
    if(daouser.findEmail(mail)==true){
         throw new Exception("Un compte existe deja pour cette adresse mail");
    }
}
    private void validatePassword(String motDePasse, String confirmation) throws Exception {
        if (motDePasse != null && confirmation != null) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 3) {
                throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");
        }
    }

    private void validateName(String nom) throws Exception {
        if (nom != null && nom.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setError(String field, String message) {
        errors.put(field, message);
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getParamValue(HttpServletRequest request, String paramKey) {
        String value = request.getParameter(paramKey);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value.trim();
        }
    }
    
   
}
