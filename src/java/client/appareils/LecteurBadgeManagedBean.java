/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.appareils;

import client.BoiteAOutils;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
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
@ApplicationScoped
public class LecteurBadgeManagedBean {
     
    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    private BorneAcces borneAcces = new BorneAcces();
    private BorneAcces borneAccesSelected;
  
    public LecteurBadgeManagedBean() {
    }
    public void modifier(){
        try {
            this.borneAccesSrv.update(this.borneAccesSelected);
             BoiteAOutils.addMessage("Succes", " lecteur de badge bien modifié.", "succesLecteurBadge");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de modifier la borne.", "errorLecteurBadge");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void addLecteurBadge(){
        try {
            this.borneAccesSrv.add(borneAcces);
            this.borneAcces = null;
            BoiteAOutils.addMessage("Succes", " lecteur de badge bien crée.", "succesLecteurBadge");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible d'ajouter le lecteur de badge.", "errorLecteurBadge");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeLecteur(){
        try {
            this.borneAccesSrv.remove(this.borneAccesSelected);
            BoiteAOutils.addMessage("Succes", " lecteur de badge est bien supprimé.", "succesLecteurBadge");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de supprimer le lecteur de badge.", "errorLecteurBadge");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BorneAcces getBorneAcces() {
        return borneAcces;
    }
    public List<BorneAcces> getBorneAccess(){
        List<BorneAcces> borneAcceses = null;
        try {
            borneAcceses = this.borneAccesSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borneAcceses;
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

    public BorneAcces getBorneAccesSelected() {
        return borneAccesSelected;
    }

    public void setBorneAccesSelected(BorneAcces borneAccesSelected) {
        this.borneAccesSelected = borneAccesSelected;
    }
}
