/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Julien Modena
 */
import java.io.IOException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import beans.User;
import forms.ConnectionForm;

public class Connection extends HttpServlet {
   
    private static final String ATT_USER = "utilisateur";
    private static final String ATT_FORM = "form";
    private static final String ATT_SESSION_USER = "sessionUtilisateur";
    private static final String VUE = "/WEB-INF/view/connection.jsp";
    private static final String ADMIN = "/WEB-INF/view/admin.jsp";
    private static final String ACCUEIL = "/accueil.jsp";
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher("/WEB-INF/view/connection.jsp").forward(request,
                response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnectionForm form = new ConnectionForm();
        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.connectUser(request);
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean user
         * à la session, sinon suppression du bean de la session.
         */
        if (form.getErrors().isEmpty()) {
            session.setAttribute(ATT_SESSION_USER, user);
        } else {
            session.setAttribute(ATT_SESSION_USER, null);
        }
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, user);
        
        System.out.println(user);
        
        if(user.isAdmin()!=0 && form.getErrors().isEmpty())
        {
            this.getServletContext()
                    .getRequestDispatcher(ACCUEIL)
                    .forward(request, response);
        }
        else{
            this.getServletContext()
                    .getRequestDispatcher(ADMIN)
                    .forward(request, response);
        }
      
    }
 
}
