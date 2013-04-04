/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utilisateur;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import metier.AttributionUtilisateurBadgeService;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.AttributionUtilisateurBadge;
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class ModificationUtilisateurManagedBean {

    private Utilisateur utilisateur = new Utilisateur();
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private AttributionUtilisateurBadge attributionUtilisateurBadge;
    private AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv = MetierFactory.getAttributionUtilisateurBadgeService();

    public ModificationUtilisateurManagedBean() {
    }

    public Utilisateur getUtilisateur() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Utilisateur s = null;
        if (session.getAttribute("modification") != null) {
            s = (Utilisateur) session.getAttribute("modification");
            this.utilisateur = s;
            attributionUtilisateurBadge = attributionUtilisateurBadgeSrv.getByUtilisateur(this.utilisateur);
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void updateUtilisateur() {
        this.utilisateurSrv.update(utilisateur);

    }

    public AttributionUtilisateurBadge getAttributionUtilisateurBadge() {
        return attributionUtilisateurBadge;
    }

    public String getString() {
        String retour = null;
        Badge b = null;
        try {
            b = this.attributionUtilisateurBadge.getBadge();
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        if (b == null) {
            retour = "L'utilisateur n'a pas de badge d'attribué.";
        } else {
            retour = "L'utilisateur procéde le badge n°" + b.getNumero() + ".";
        }
        return retour;
    }

    public void setAttributionUtilisateurBadge(AttributionUtilisateurBadge attributionUtilisateurBadge) {
        this.attributionUtilisateurBadge = attributionUtilisateurBadge;
    }

    public String getTextOfOutputTextRemove() {
        String retour = new String();
        if (this.getAttributionUtilisateurBadge() != null) {
            if (this.attributionUtilisateurBadge.getBadge() != null) {
                retour = "Rendre le badge";
            } else {
                retour = " ";
            }
        }

        return retour;
    }

    public void removeBadgeFromUtilisateur() {
        try {
            this.attributionUtilisateurBadgeSrv.remove(attributionUtilisateurBadge);
        } catch (Exception ex) {
            Logger.getLogger(ModificationUtilisateurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
