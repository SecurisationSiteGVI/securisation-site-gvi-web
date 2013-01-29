/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.secteur;

import client.BoiteAOutils;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.AttributionSecteurBorneAccesService;
import metier.AttributionSecteurCameraService;
import metier.AttributionSecteurDetecteurIntrusionService;
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
@RequestScoped//succesListSecteur 
public class ListSecteurManagedBean {

    private AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv = MetierFactory.getAttributionSecteurBorneAccesService();
    private AttributionSecteurDetecteurIntrusionService attributionSecteurDetecteurIntrusionSrv = MetierFactory.getAttributionSecteurDetecteurIntrusionService();
    private AttributionSecteurCameraService attributionSecteurCameraSrv = MetierFactory.getAttributionSecteurCameraService();
    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private List<Secteur> secteurs;
    private Secteur secteurSelected;
    private List<Object> objectsInSecteur = new ArrayList<Object>();

    public List<Secteur> getSecteurs() {
        try {
            this.secteurs = this.secteurSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " imossible de récupéré la liste des secteurs.", "errorListSecteur");
            Logger.getLogger(ListSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secteurs;
    }

    public void viewDevicesInSecteur() {
        List<BorneAcces> borneAcceses = null;
        List<Camera> camera = null;
        List<DetecteurIntrusion> detecteurIntrusions = null;
        if (this.secteurSelected != null) {
            AttributionSecteurBorneAcces attributionSecteurBorneAcces = attributionSecteurBorneAccesSrv.getBySecteur(secteurSelected);
            if (!attributionSecteurBorneAcces.getBorneAccess().isEmpty()) {
                borneAcceses = attributionSecteurBorneAcces.getBorneAccess();
            }
            AttributionSecteurCamera attributionSecteurCamera = this.attributionSecteurCameraSrv.getBySecteur(secteurSelected);
            if (attributionSecteurCamera.getCameras() != null) {
                camera = attributionSecteurCamera.getCameras();
            }
            AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion = this.attributionSecteurDetecteurIntrusionSrv.getBySecteur(secteurSelected);
            if (attributionSecteurDetecteurIntrusion.getDetecteurIntrusions() != null) {
                detecteurIntrusions = attributionSecteurDetecteurIntrusion.getDetecteurIntrusions();
            }
            this.objectsInSecteur = null;
            if (borneAcceses != null) {
                objectsInSecteur.addAll(borneAcceses);
            }
            if (camera != null) {
                objectsInSecteur.addAll(camera);
            }
            if (detecteurIntrusions != null) {
                objectsInSecteur.addAll(detecteurIntrusions);
            }
        }
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public Secteur getSecteurSelected() {
        return secteurSelected;
    }

    public void setSecteurSelected(Secteur secteurSelected) {
        this.secteurSelected = secteurSelected;
    }

    public List<Object> getObjectsInSecteur() {
        return objectsInSecteur;
    }

    public void setObjectsInSecteur(List<Object> objectsInSecteur) {
        this.objectsInSecteur = objectsInSecteur;
    }
}
