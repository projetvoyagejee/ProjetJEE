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
public class Date {
    private String jour;
    private String mois;
    private String annee;

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public Date() {
    }

    public Date(String jour, String mois, String annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    
    

}
