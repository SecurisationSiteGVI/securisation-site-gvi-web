/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.numeroTelephone;

import client.BoiteAOutils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.NumeroPredefinisService;
import metier.entitys.NumeroPredefinis;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class GererNumerosPredefinisManagedBean {

    private NumeroPredefinisService numeroPredefinisSrv = MetierFactory.getNumeroPredefinisService();
    private String numeroAAjouter = new String();
    private String numeroASupprimer;

    public GererNumerosPredefinisManagedBean() {
    }

    public void ajouterUnNumero() {
        if (this.numeroAAjouter != null) {
            try {
                this.numeroPredefinisSrv.ajouterUnNumero(this.numeroAAjouter);
                this.numeroAAjouter = null;
                BoiteAOutils.addMessage("Succes", " numéro bien ajouté.", "succesNumerolist");
            } catch (Exception ex) {
                BoiteAOutils.addMessage("Erreur", " imossible d'ajouter le numéro", "errorNumerolist");
                Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void supprimerUnNumero() {
        if (this.getNumeroASupprimer() != null) {
            try {
                this.numeroPredefinisSrv.supprimerUnNumero(this.getNumeroASupprimer());
                BoiteAOutils.addMessage("Succes", " numéro bien supprimé.", "succesNumerolist");
            } catch (Exception ex) {
                BoiteAOutils.addMessage("Erreur", " impossible de supprimer le numéro.", "errorNumerolist");
                Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<String> getNumeros() {
        List<NumeroPredefinis> np = null;
        List<String> numeros = null;
        try {
            np = this.numeroPredefinisSrv.getAll();
            numeros = np.get(0).getNumeros();
        } catch (Exception ex) {
            if (ex instanceof NullPointerException) {
                System.out.println("la liste est vide.");
            }
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeros;
    }

    public String getNumeroAAjouter() {
        return numeroAAjouter;
    }

    public void setNumeroAAjouter(String numeroAAjouter) {
        this.numeroAAjouter = numeroAAjouter;
    }

    public String getNumeroASupprimer() {
        return numeroASupprimer;
    }

    public void setNumeroASupprimer(String numeroASupprimer) {
        this.numeroASupprimer = numeroASupprimer;
    }
}
