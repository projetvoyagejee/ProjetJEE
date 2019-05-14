/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author Julien Modena
 */
public class Commentaire {
    private int id_commentaire;
    private String contenu;
    private int etat_Signal;
    private int id_utilisateur;
    private int id_Articles;

 
    public Commentaire() {
    }

    public Commentaire(int id_commentaire, String contenu, int etat_Signal, int id_utilisateur, int id_Articles) {
        this.id_commentaire = id_commentaire;
        this.contenu = contenu;
        this.etat_Signal = etat_Signal;
        this.id_utilisateur = id_utilisateur;
        this.id_Articles = id_Articles;
    }

    
    
    public int getId_Articles() {
        return id_Articles;
    }

    public void setId_Articles(int id_Articles) {
        this.id_Articles = id_Articles;
    }
    
    
    
    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getEtat_Signal() {
        return etat_Signal;
    }

    public void setEtat_Signal(int etat_Signal) {
        this.etat_Signal = etat_Signal;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
    
    
}
