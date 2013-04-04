/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utilisateur;

import client.BoiteAOutils;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean(name = "utilisateurManagedBean")
@ViewScoped//@ApplicationScoped
public class UtilisateurManagedBean {

    private Utilisateur utilisateur = new Utilisateur();
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private List<String> utilisateurProperties = new ArrayList<String>();
    private int index;
    private int nbLinge = 10;
    private List<Utilisateur> utilisateurs = null;
    private String choixCB;
    private String textFilter;
    private Utilisateur idUtilisateur;
    private Utilisateur utilisateurUpdate;

    public void removeUtilisateur() {
        if (getIdUtilisateur() != null) {

            this.utilisateurSrv.remove(getIdUtilisateur());
        } else {
            BoiteAOutils.addMessage("Erreur", " impossible de recuperer l'id ");
        }

    }

    public void filtrer() {
        this.index = 0;
        System.out.println("FILTER");
    }

    public UtilisateurManagedBean() {
        this.addIntoUtilisateurPropertiers();
        this.index = 0;
        this.utilisateurs = this.utilisateurSrv.getAllByRange(0, nbLinge);
        this.choixCB = " ";
    }

    private void addIntoUtilisateurPropertiers() {
        getUtilisateurProperties().add(" ");
        getUtilisateurProperties().add("Nom");
        getUtilisateurProperties().add("Prénom");
        getUtilisateurProperties().add("Ville");
        getUtilisateurProperties().add("Code postale");
        getUtilisateurProperties().add("Adresse");
        getUtilisateurProperties().add("Email");
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

    public List<Utilisateur> getUtilisateurs() {
        if (this.choixCB.equals(" ")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getAllByRange(index, nbLinge);
        } else if (this.choixCB.equals("Nom")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByNom(textFilter, index, nbLinge);
        } else if (this.choixCB.equals("Prénom")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByPrenom(textFilter, index, nbLinge);
        } else if (this.choixCB.equals("Ville")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByVille(textFilter, index, nbLinge);
        } else if (this.choixCB.equals("Code postale")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByCodePostale(Integer.parseInt(textFilter), index, nbLinge);
        } else if (this.choixCB.equals("Adresse")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByAdresse(textFilter, index, nbLinge);
        } else if (this.choixCB.equals("Email")) {
            this.utilisateur = null;
            this.utilisateurs = this.utilisateurSrv.getByEmail(textFilter, index, nbLinge);
        }
        return utilisateurs;

    }

    public List<String> getUtilisateurProperties() {
        return utilisateurProperties;
    }

    public void updateUtilisateur() {
        System.out.println(utilisateurUpdate);
        this.utilisateurSrv.update(utilisateurUpdate);
    }

    public String modifier() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("modification", this.utilisateurUpdate);
        return "modifUtilisateur.jsf";
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

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public String getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }

    public String getChoixCB() {
        return choixCB;
    }

    public void setChoixCB(String choixCB) {
        this.choixCB = choixCB;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur getUtilisateurUpdate() {
        return utilisateurUpdate;
    }

    public void setUtilisateurUpdate(Utilisateur utilisateurUpdate) {
        this.utilisateurUpdate = utilisateurUpdate;
    }
}
