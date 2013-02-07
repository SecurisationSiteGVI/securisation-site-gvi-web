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
    private String gererBadges = " ";
    private String listeBadges = " ";
    private String ajouterBadge = " ";
    private String atributionBadge =" ";
    private String gererSecteur=" ";
    private String gererSecteur2 = " ";
    private String modificationUtilisateur=" ";
    private String attributionSecteur=" ";
    private String gererAppareil=" ";
    private String gererLecteurBadge=" ";
    private String video=" ";
    private String gererCamera=" ";
    private String gererDetecteurIntrusion =" ";
    private String gererPosition=" ";
    private String visionageCamera=" ";
    private String gererNumeroPredefini = " ";
    private String numeroPredefiniGmail = " ";
    private String gererNumeros = " ";
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
        if ("utilisateurs/modifUtilisateur.xhtml".equals(url)) {
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
        if ("badge/attributionBadge.xhtml".equals(url)) {
            this.gererBadges = "active";
            this.atributionBadge = "active";
        }
        if ("secteur/gererSecteur.xhtml".equals(url)) {
            this.gererSecteur2 = "active";
            this.gererSecteur = "active";
        }
        if ("secteur/attributionSecteur.xhtml".equals(url)) {
            this.attributionSecteur = "active";
            this.gererSecteur = "active";
        }if ("appareils/gererLecteurBadge.xhtml".equals(url)) {
            this.gererAppareil = "active";
            this.gererLecteurBadge = "active";
        }
        if ("appareils/gererCamera.xhtml".equals(url)) {
            this.gererAppareil = "active";
            this.gererCamera = "active";
        }
        if ("appareils/gererDetecteurIntrusion.xhtml".equals(url)) {
            this.gererAppareil = "active";
            this.gererDetecteurIntrusion = "active";
        }
        if ("appareils/gererPosition.xhtml".equals(url)) {
            this.gererAppareil = "active";
            this.gererPosition = "active";
        }
         if ("video/visionageCamera.xhtml".equals(url)) {
            this.video = "active";
            this.visionageCamera = "active";
        }
         if ("numeroPredefini/numeroPredefiniGmail.xhtml".equals(url)) {
            this.gererNumeroPredefini = "active";
            this.numeroPredefiniGmail = "active";
        }
         if ("numeroPredefini/gererNumeros.xhtml".equals(url)) {
            this.gererNumeroPredefini = "active";
            this.gererNumeros = "active";
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

    public String getAtributionBadge() {
        return atributionBadge;
    }

    public void setAtributionBadge(String atributionBadge) {
        this.atributionBadge = atributionBadge;
    }

  

    public String getAjouterSecteur() {
        return gererSecteur;
    }

    public void setAjouterSecteur(String ajouterSecteur) {
        this.gererSecteur = ajouterSecteur;
    }

    public String getGererSecteur() {
        return gererSecteur;
    }

    public void setGererSecteur(String gererSecteur) {
        this.gererSecteur = gererSecteur;
    }

    public String getModificationUtilisateur() {
        return modificationUtilisateur;
    }

    public void setModificationUtilisateur(String modificationUtilisateur) {
        this.modificationUtilisateur = modificationUtilisateur;
    }

    

    public String getGererAppareil() {
        return gererAppareil;
    }

    public void setGererAppareil(String gererAppareil) {
        this.gererAppareil = gererAppareil;
    }

    public String getGererLecteurBadge() {
        return gererLecteurBadge;
    }

    public void setGererLecteurBadge(String gererLecteurBadge) {
        this.gererLecteurBadge = gererLecteurBadge;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getGererCamera() {
        return gererCamera;
    }

    public void setGererCamera(String gererCamera) {
        this.gererCamera = gererCamera;
    }

    public String getGererDetecteurIntrusion() {
        return gererDetecteurIntrusion;
    }

    public void setGererDetecteurIntrusion(String gererDetecteurIntrusion) {
        this.gererDetecteurIntrusion = gererDetecteurIntrusion;
    }

    public String getGererPosition() {
        return gererPosition;
    }

    public void setGererPosition(String gererPosition) {
        this.gererPosition = gererPosition;
    }

    /**
     * @return the visionageCamera
     */
    public String getVisionageCamera() {
        return visionageCamera;
    }

    /**
     * @param visionageCamera the visionageCamera to set
     */
    public void setVisionageCamera(String visionageCamera) {
        this.visionageCamera = visionageCamera;
    }

    public String getGererSecteur2() {
        return gererSecteur2;
    }

    public void setGererSecteur2(String gererSecteur2) {
        this.gererSecteur2 = gererSecteur2;
    }

    public String getAttributionSecteur() {
        return attributionSecteur;
    }

    public void setAttributionSecteur(String attributionSecteur) {
        this.attributionSecteur = attributionSecteur;
    }

    public String getGererNumeroPredefini() {
        return gererNumeroPredefini;
    }

    public void setGererNumeroPredefini(String gererNumeroPredefini) {
        this.gererNumeroPredefini = gererNumeroPredefini;
    }

    public String getNumeroPredefiniGmail() {
        return numeroPredefiniGmail;
    }

    public void setNumeroPredefiniGmail(String numeroPredefiniGmail) {
        this.numeroPredefiniGmail = numeroPredefiniGmail;
    }

    public String getGererNumeros() {
        return gererNumeros;
    }

    public void setGererNumeros(String gererNumeros) {
        this.gererNumeros = gererNumeros;
    }
}
