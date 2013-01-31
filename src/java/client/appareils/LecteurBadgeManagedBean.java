/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.appareils;

import client.BoiteAOutils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.BorneAccesService;
import metier.MetierFactory;
import metier.PositionService;
import metier.entitys.BorneAcces;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class LecteurBadgeManagedBean {
    //succesLecteurBadge 
    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    private BorneAcces borneAcces = new BorneAcces();
    public LecteurBadgeManagedBean() {
    }
    public void addLecteurBadge(){
        try {
            this.borneAccesSrv.add(borneAcces);
            this.borneAcces = null;
            BoiteAOutils.addMessage("Succes", " lecteur de badge bien crée.", "errorLecteurBadge");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible d'ajouter le lecteur de badge.", "errorLecteurBadge");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BorneAcces getBorneAcces() {
        return borneAcces;
    }

    public List<Position> getPositions(){
        PositionService positionSrv = MetierFactory.getPositionService();
        List<Position> positions = null;
        try {
            positions = positionSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste des positions.", "errorLecteurBadge");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return positions;
    }
    public void setBorneAcces(BorneAcces borneAcces) {
        this.borneAcces = borneAcces;
    }
}
