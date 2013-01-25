/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.badge;

import java.util.List;
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
@RequestScoped
public class AttributionBadgeManagedBean {

    private AttributionUtilisateurBadge attributionUtilisateurBadge = new AttributionUtilisateurBadge();
    private AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv = MetierFactory.getAttributionUtilisateurBadgeService();
    private List<Badge> badges;
    private List<Utilisateur> utilisateurs;
    private int indexBadge;
    private int indexUtilisateur;
    private int nbResult=10;
    public AttributionBadgeManagedBean() {
        this.indexBadge=0;
        this.badges = this.attributionUtilisateurBadgeSrv.getBadgesNotAssign(this.indexBadge, this.nbResult);
        this.utilisateurs = this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssign(this.indexUtilisateur, this.nbResult);
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

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
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

    
}
