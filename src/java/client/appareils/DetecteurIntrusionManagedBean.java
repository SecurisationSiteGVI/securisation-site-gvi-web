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
import metier.DetecteurIntrusionService;
import metier.MetierFactory;
import metier.PositionService;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class DetecteurIntrusionManagedBean {

    private DetecteurIntrusionService detecteurIntrusionSrv= MetierFactory.getDetecteurIntrusionService();
    private DetecteurIntrusion detecteurIntrusion = new DetecteurIntrusion();
    private DetecteurIntrusion detecteurIntrusionSelected;
    public DetecteurIntrusionManagedBean() {
    }
    public void addDetecteurIntrusion(){
        try {
            this.detecteurIntrusionSrv.add(detecteurIntrusion);
            this.detecteurIntrusion = null;
            BoiteAOutils.addMessage("Succes", " le détecteur d'intrusion à bien été crée", "succesDetecteurIntrusion");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de ajouter un détécteur intrusion", "errorDetecteurIntrusion");
            Logger.getLogger(DetecteurIntrusionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeDetecteurIntrusion(){
        try {
            this.detecteurIntrusionSrv.remove(this.detecteurIntrusionSelected);
            BoiteAOutils.addMessage("Succes", " le détecteur d'intrusion à bien été supprimé", "succesDetecteurIntrusion");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de supprimer le détécteur intrusion", "errorDetecteurIntrusion");
            Logger.getLogger(DetecteurIntrusionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<DetecteurIntrusion> getDetecteurIntrusions(){
        List<DetecteurIntrusion> detecteurIntrusions = null;
        try {
            detecteurIntrusions = this.detecteurIntrusionSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste de détécteur intrusion", "errorDetecteurIntrusion");
            Logger.getLogger(DetecteurIntrusionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detecteurIntrusions;
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

    public DetecteurIntrusion getDetecteurIntrusionSelected() {
        return detecteurIntrusionSelected;
    }

    public void setDetecteurIntrusionSelected(DetecteurIntrusion detecteurIntrusionSelected) {
        this.detecteurIntrusionSelected = detecteurIntrusionSelected;
    }

    public DetecteurIntrusion getDetecteurIntrusion() {
        return detecteurIntrusion;
    }

    public void setDetecteurIntrusion(DetecteurIntrusion detecteurIntrusion) {
        this.detecteurIntrusion = detecteurIntrusion;
    }
}
