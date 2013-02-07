/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.secteur;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import metier.AttributionSecteurBorneAccesService;
import metier.AttributionSecteurCameraService;
import metier.AttributionSecteurDetecteurIntrusionService;
import metier.BorneAccesService;
import metier.CameraService;
import metier.DetecteurIntrusionService;
import metier.MetierFactory;
import metier.SecteurService;
import metier.entitys.AttributionSecteurBorneAcces;
import metier.entitys.AttributionSecteurCamera;
import metier.entitys.AttributionSecteurDetecteurIntrusion;
import metier.entitys.BorneAcces;
import metier.entitys.Camera;
import metier.entitys.DetecteurIntrusion;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
@ManagedBean
@ViewScoped
public class AttributionSecteurManagedBean {

    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    private DetecteurIntrusionService detecteurIntrusionSrv = MetierFactory.getDetecteurIntrusionService();
    private CameraService cameraSrv = MetierFactory.getCameraService();
    private AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv = MetierFactory.getAttributionSecteurBorneAccesService();
    private AttributionSecteurCameraService attributionSecteurCameraSrv = MetierFactory.getAttributionSecteurCameraService();
    private AttributionSecteurDetecteurIntrusionService attributionSecteurDetecteurIntrusionSrv = MetierFactory.getAttributionSecteurDetecteurIntrusionService();
    private Secteur secteurSelected;
    private BorneAcces borneAccesSelected;

    public List<Secteur> getSecteurs() {
        List<Secteur> secteurs = null;
        try {
            secteurs = this.secteurSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secteurs;
    }

    public void attribuerBorne() {
        this.attributionSecteurBorneAccesSrv.attribuerBorneAcces(this.secteurSelected, this.borneAccesSelected);
    }

    public void setDynamicSecteurSelected(ValueChangeEvent evt) {
        Secteur s = (Secteur) evt.getNewValue();
        this.secteurSelected = s;
    }

    public List<Camera> getCameras() {
        List<Camera> cameras = null;
        try {
            cameras = this.cameraSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cameras;
    }

    public List<BorneAcces> getBorneAcceses() {
        List<BorneAcces> borneAcceses = null;
        try {
            borneAcceses = this.borneAccesSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borneAcceses;
    }

    public List<DetecteurIntrusion> getDetecteurIntrusions() {
        List<DetecteurIntrusion> detecteurIntrusions = null;
        try {
            detecteurIntrusions = this.detecteurIntrusionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detecteurIntrusions;
    }

    public List<Object> getAppareilsBySecteur() {
        List<Object> objects = new ArrayList<Object>();
        if (this.secteurSelected != null) {
            AttributionSecteurBorneAcces attributionSecteurBorneAcceses = this.attributionSecteurBorneAccesSrv.getBySecteur(this.secteurSelected);
            if (attributionSecteurBorneAcceses != null) {
                List<BorneAcces> borneAcceses = attributionSecteurBorneAcceses.getBorneAccess();
                if (!borneAcceses.isEmpty()) {
                    objects.addAll(borneAcceses);
                }
            }
            AttributionSecteurCamera attributionSecteurCamera = this.attributionSecteurCameraSrv.getBySecteur(this.secteurSelected);
            if (attributionSecteurCamera != null) {
                List<Camera> cameras = attributionSecteurCamera.getCameras();
                if (!cameras.isEmpty()) {
                    objects.addAll(cameras);
                }
            }
            AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion = this.attributionSecteurDetecteurIntrusionSrv.getBySecteur(secteurSelected);
            if (attributionSecteurDetecteurIntrusion != null) {
                List<DetecteurIntrusion> detecteurIntrusions = attributionSecteurDetecteurIntrusion.getDetecteurIntrusions();
                if (!detecteurIntrusions.isEmpty()) {
                    objects.addAll(detecteurIntrusions);
                }
            }
        }
        return objects;
    }

    public Secteur getSecteurSelected() {
        Secteur secteur = null;
        if(this.secteurSelected==null){
            try {
                secteur = this.secteurSrv.getAll().get(0);
                this.secteurSelected = secteur;
            } catch (Exception ex) {
                Logger.getLogger(AttributionSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return secteurSelected;
    }

    public void setSecteurSelected(Secteur secteurSelected) {
        this.secteurSelected = secteurSelected;
    }

    public BorneAcces getBorneAccesSelected() {
        return borneAccesSelected;
    }

    public void setBorneAccesSelected(BorneAcces borneAccesSelected) {
        this.borneAccesSelected = borneAccesSelected;
    }
}
