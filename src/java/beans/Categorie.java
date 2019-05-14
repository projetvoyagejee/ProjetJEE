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
public class Categorie {
    private int id_categorie;
    private String categorie;

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie() {
    }

    public Categorie(int id_categorie, String categorie) {
        this.id_categorie = id_categorie;
        this.categorie = categorie;
    }
    
   

}
