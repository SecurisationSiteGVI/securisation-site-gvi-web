/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.badge;

import client.BoiteAOutils;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.AttributionUtilisateurBadgeService;
import metier.MetierFactory;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean
@ApplicationScoped
public class AttributionBadgeManagedBean {

    private AttributionUtilisateurBadge attributionUtilisateurBadge = new AttributionUtilisateurBadge();
    private AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv = MetierFactory.getAttributionUtilisateurBadgeService();
    private List<Badge> badges;
    private List<Utilisateur> utilisateurs;
    private int indexBadge;
    private int indexUtilisateur;
    private int nbResult = 10;
    private Badge badgeSelectionne;
    private String textFilter =new String();
    private Utilisateur utilisateurSelectionne;

    public void filtrer() {
        this.indexUtilisateur = 0;

    }

    public AttributionBadgeManagedBean() {
        this.indexBadge = 0;
        this.badges = this.attributionUtilisateurBadgeSrv.getBadgesNotAssign(this.indexBadge, this.nbResult);

    }

    public AttributionUtilisateurBadge getAttributionUtilisateurBadge() {
        return attributionUtilisateurBadge;
    }

    public void setAttributionUtilisateurBadge(AttributionUtilisateurBadge attributionUtilisateurBadge) {
        this.attributionUtilisateurBadge = attributionUtilisateurBadge;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void pagePrécédente() {
        if (this.indexUtilisateur <= nbResult - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorPageutili");
        } else {
            this.indexUtilisateur = this.indexUtilisateur - nbResult;
        }
    }

    public void pageSuivant() {
        this.indexUtilisateur = this.indexUtilisateur + nbResult;
    }

    public void selectionBadge() {
    }

    public void selectionUtilisateur() {
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Utilisateur> getUtilisateurs() {
        if (this.textFilter.length()>=1) {
             this.utilisateurs = this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssignByNom(this.textFilter, this.indexUtilisateur, this.nbResult);
        } else {
           this.utilisateurs = this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssign(this.indexUtilisateur, this.nbResult);
        }

        return utilisateurs;
    }

    public int getPage() {
        int page = indexUtilisateur / nbResult;
        return page;

    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public int getIndexBadge() {
        return indexBadge;
    }

    public void setIndexBadge(int indexBadge) {
        this.indexBadge = indexBadge;
    }

    public int getIndexUtilisateur() {
        return indexUtilisateur;
    }

    public void setIndexUtilisateur(int indexUtilisateur) {
        this.indexUtilisateur = indexUtilisateur;
    }

    public int getNbResult() {
        return nbResult;
    }

    public void setNbResult(int nbResult) {
        this.nbResult = nbResult;
    }

    public Badge getBadgeSelectionne() {
        return badgeSelectionne;
    }

    public void setBadgeSelectionne(Badge badgeSelectionne) {
        this.badgeSelectionne = badgeSelectionne;
    }

    public Utilisateur getUtilisateurSelectionne() {
        return utilisateurSelectionne;
    }

    public void setUtilisateurSelectionne(Utilisateur utilisateurSelectionne) {
        this.utilisateurSelectionne = utilisateurSelectionne;
    }

    public String getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }
}
