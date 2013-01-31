/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.appareils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.BorneAccesService;
import metier.MetierFactory;
import metier.entitys.BorneAcces;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class LecteurBadgeManagedBean {

    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    private BorneAcces borneAcces = new BorneAcces();
    public LecteurBadgeManagedBean() {
    }
    public void addLecteurBadge(){
        
    }

    public BorneAcces getBorneAcces() {
        return borneAcces;
    }

    public void setBorneAcces(BorneAcces borneAcces) {
        this.borneAcces = borneAcces;
    }
}
