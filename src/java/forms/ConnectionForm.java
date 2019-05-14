/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import DAO.DAOUser;
import beans.User;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Julien Modena
 */
public class ConnectionForm {

    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private String result;
    private final Map<String, String> errors = new HashMap<>();
    DAOUser daouse = new DAOUser();

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
    public User connectUser(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String email = getParamValue(request, EMAIL);
        String pwd = getParamValue(request, PASSWORD);
         
        
        User user = new User();
        /* Validation du champ email. */
        try {
            validateEmail(email);
        } catch (Exception e) {
            setError(EMAIL, e.getMessage());
        }
        user.setEmail(email);
        /* Validation du champ mot de passe. */
        try {
            validatePassword(pwd);
        } catch (Exception e) {
            setError(PASSWORD, e.getMessage());
        }
        try{
            verifieLog(email,pwd);
            
        }catch (Exception e){
            setError(EMAIL,e.getMessage());
        }
        user.setPassword(pwd);
        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de la connexion.";
        } else {
            result += "Échec de la connexion.";
        }
        return user;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validateEmail(String email)
            throws Exception {
        if (email == null) {
            throw new Exception("Merci de saisir une adresse mail.");
        } else if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            throw new Exception("Merci de saisir une adresse mailvalide. ");
        }
    }

// fonction qui recupere l'email et le mot de passe si ils sont inscrit dans la base de données autorise l'accès 
    
private void verifieLog(String mail, String pwd) throws Exception{
  if(mail.length()!=0 && pwd.length()!=0)
  {
    if(daouse.findLog(mail,pwd)==false){
         throw new Exception("Vos identifiant sont incorrect");
    }
  }
  else{
      throw new Exception("Vous n'avez pas saisie d'identifiants");
  }
}
    /**
     * Valide le mot de passe saisi.
     */
    private void validatePassword(String password)
            throws Exception {
        if (password != null) {
            if (password.length() < 3) {
                throw new Exception(
                        "Le mot de passe doit contenir au moins 3 caractères. ");
            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
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
            return value.trim();
        }
    }
      public static String encryptThisString(String input) {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            // return the HashText
            return hashtext;
        } // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

