/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.secteur;

import client.BoiteAOutils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.SecteurService;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class AddSecteurManagedBean {
    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private Secteur secteur = new Secteur();
    public AddSecteurManagedBean() {
    }// // 
    public void addSecteur(){
        try {
            this.secteurSrv.add(secteur);
            this.secteur= null;
            BoiteAOutils.addMessage("Succes"," secteur bien ajouté", "succesAddSecteur");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Error"," secteur n'a pas pu étre ajouté", "errorAddSecteur");
            Logger.getLogger(AddSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
