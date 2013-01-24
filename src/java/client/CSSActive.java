/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author damien
 */
@ManagedBean
public class CSSActive {

    private String active = "active";
    private String url;
    private String pageTechnicien = " ";
    private String histrorique = " ";
    private String utilisateur = " ";
    private String listeUtilisateur = " ";
    private String ajouterUtilisateurs = " ";
    private String gererBadges=" ";
    private String listeBadges =" ";
    private String ajouterBadge = " ";
    
    public CSSActive() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.url = context.getViewRoot().getViewId();
        this.url = url.substring(1);
        if ("pageTechnicien.xhtml".equals(url)) {
            this.pageTechnicien = "active";
        }
        if ("histrorique.xhtml".equals(url)) {
            this.histrorique = "active";
        }
        if ("utilisateurs/ajouterUtilisateurs.xhtml".equals(url)) {
            this.utilisateur = "active";
            this.ajouterUtilisateurs = "active";
        }
        if ("utilisateurs/listeUtilisateur.xhtml".equals(url)) {
            this.utilisateur = "active";
            this.listeUtilisateur = "active";
        }
        if ("badge/listeBadges.xhtml".equals(url)) {
            this.listeBadges = "active";
            this.gererBadges = "active";
        }
        if ("badge/ajouterBadge.xhtml".equals(url)) {
            this.gererBadges = "active";
            this.ajouterBadge = "active";
        }

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageTechnicien() {
        return pageTechnicien;
    }

    public void setPageTechnicien(String pageTechnicien) {
        this.pageTechnicien = pageTechnicien;
    }

    public String getHistrorique() {
        return histrorique;
    }

    public void setHistrorique(String histrorique) {
        this.histrorique = histrorique;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getListeUtilisateur() {
        return listeUtilisateur;
    }

    public void setListeUtilisateur(String listeUtilisateur) {
        this.listeUtilisateur = listeUtilisateur;
    }

    public String getAjouterUtilisateurs() {
        return ajouterUtilisateurs;
    }

    public void setAjouterUtilisateurs(String ajouterUtilisateurs) {
        this.ajouterUtilisateurs = ajouterUtilisateurs;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getGererBadges() {
        return gererBadges;
    }

    public void setGererBadges(String gererBadges) {
        this.gererBadges = gererBadges;
    }

    public String getListeBadges() {
        return listeBadges;
    }

    public void setListeBadges(String listeBadges) {
        this.listeBadges = listeBadges;
    }

    public String getAjouterBadge() {
        return ajouterBadge;
    }

    public void setAjouterBadge(String ajouterBadge) {
        this.ajouterBadge = ajouterBadge;
    }
}
