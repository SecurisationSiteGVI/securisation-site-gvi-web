/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Technicien;
import metier.entitys.Utilisateur;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author damien
 */
@ManagedBean(name = "utilisateurManagedBean")
@ApplicationScoped
public class UtilisateurManagedBean {

    private Utilisateur utilisateur = new Utilisateur();
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private Number number;
    private List<String> utilisateurProperties = new ArrayList<String>();
    private int index;
    private int nbLinge = 10;

    public UtilisateurManagedBean() {
        this.addIntoUtilisateurPropertiers();
        this.index = 0;
    }

    private void addIntoUtilisateurPropertiers() {
        getUtilisateurProperties().add("Nom");
        getUtilisateurProperties().add("Prénom");
        getUtilisateurProperties().add("Ville");
        getUtilisateurProperties().add("Code postale");
        getUtilisateurProperties().add("Adresse");
        getUtilisateurProperties().add("homme");
        getUtilisateurProperties().add("email");
    }

    public void addUtilisateur() {
        try {
            utilisateurSrv.add(utilisateur);
            BoiteAOutils.addMessage("Ajout effectué", "l'utilisateur est bien ajouté", "sucssesUser");
            this.utilisateur = null;
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Problème lors de l'ajout", "l'utilisateur n'a pas été ajouté", "errorUser");
            System.out.println(ex);
        }
    }

    public int getPage() {
        int page = index / nbLinge;
        return page;

    }

    public List<Utilisateur> getUtilisateurByRange() {
        int debut = index;
        int fin = index + nbLinge;
        System.out.println("debut " + debut + " fin " + fin);
        List<Utilisateur> u = null;
        try {
            u = this.utilisateurSrv.getAllByRange(debut, nbLinge);
        } catch (Exception e) {
            System.out.println("pb");
        }
        return u;
    }

    public void pageSuivant() {
        this.index = this.index + nbLinge;

    }

    public void pagePrécédente() {
        if (this.index <= nbLinge - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorPageutili");
        } else {
            this.index = this.index - nbLinge;
        }


    }

    public Long getCount() {
        return this.utilisateurSrv.count();
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public List<Utilisateur> getUtilisateurs() {
        List<Utilisateur> utilisateurs = null;
        try {
            utilisateurs = utilisateurSrv.getAll();
        } catch (Exception ex) {
            System.out.println(ex);
            BoiteAOutils.addMessage("Impossible de recuperer la liste", " veuillez reessayer ulterieurement ", "errorListeUtilisateur");
        }
        return utilisateurs;

    }

    public List<String> getUtilisateurProperties() {
        return utilisateurProperties;
    }

    public void setUtilisateurProperties(List<String> utilisateurProperties) {
        this.utilisateurProperties = utilisateurProperties;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getNbLinge() {
        return nbLinge;
    }

    public void setNbLinge(int nbLinge) {
        this.nbLinge = nbLinge;
    }
}
