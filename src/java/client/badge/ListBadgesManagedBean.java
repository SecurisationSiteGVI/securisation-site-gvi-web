/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.badge;

import client.BoiteAOutils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
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
@ApplicationScoped
public class ListBadgesManagedBean {

    private BadgeService badgeSrv = MetierFactory.getBadgeService();
    private List<Badge> badges;
    private int index=0;
    private int nbResult = 10;

    public ListBadgesManagedBean() {
       // this.index = 0;
        try {
            this.badges = this.badgeSrv.getAll(index, nbResult);
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste des badges", "errorListBadges");
            Logger.getLogger(ListBadgesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Long getCount(){
        return this.badgeSrv.count();
    }
    public int getPage() {
        int page = index / nbResult;
        return page;
    }

    public List<Badge> getBadges() {
        this.badges = null;
        try {
            this.badges = this.badgeSrv.getAll(index, nbResult);
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste", "errorListBadges");
            Logger.getLogger(ListBadgesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return badges;
    }

    public void pageSuivante() {
        this.index = this.index + nbResult;
    }

    public void pagePrecedente() {
        if (this.index <= nbResult - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorPageutili");
        } else {
            this.index = this.index - nbResult;
        }
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }
}
