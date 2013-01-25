/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.badge;

import client.BoiteAOutils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import metier.BadgeService;
import metier.MetierFactory;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
@ManagedBean

public class AddBadgeManagedBean {

    private Badge badge = new Badge();
    private BadgeService badgeSrv = MetierFactory.getBadgeService();
    
    public void addBadge() {
        try {
            badgeSrv.add(badge);
            BoiteAOutils.addMessage("Succes", "le badge à bien été ajouté", "succesAddBadge");
            this.badge = null;
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", "le badge n'a pas pu étre ajouté", "errorAddBadge");
            Logger.getLogger(AddBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
