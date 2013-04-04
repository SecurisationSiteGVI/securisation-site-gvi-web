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
import metier.BadgeService;
import metier.MetierFactory;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class RemoveBadgeManagedBean {

    private Badge badge;
    private BadgeService badgeSrv = MetierFactory.getBadgeService();
    public void removeBadge() {
        if(getBadge()!=null){
            try {
                badgeSrv.remove(getBadge());
                BoiteAOutils.addMessage("Succes", " badge bien supprimée", "succesRemoveBadge");
                this.setBadge(null);
            } catch (Exception ex) {
                BoiteAOutils.addMessage("Erreur", " impossible de supprimée le badge", "errorRemoveBadge");
                Logger.getLogger(RemoveBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }
}
