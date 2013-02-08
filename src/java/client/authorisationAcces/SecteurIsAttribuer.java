/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.authorisationAcces;

import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class SecteurIsAttribuer {
    private Secteur secteur;
    private boolean atribuer;

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public boolean isAtribuer() {
        return atribuer;
    }

    public void setAtribuer(boolean atribuer) {
        this.atribuer = atribuer;
    }
    @Override
    public String toString(){
        return secteur.toString();
        
    }
}
