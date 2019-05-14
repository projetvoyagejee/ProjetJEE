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
public class Article {
    private int id_article;
    private String nom;
    private String categorie;
    private int score;
    private String contenu;

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Article() {
    }

    public Article(int id_article, String nom, String categorie, int score, String contenu) {
        this.id_article = id_article;
        this.nom = nom;
        this.categorie = categorie;
        this.score = score;
        this.contenu = contenu;
    }
    
    
}
