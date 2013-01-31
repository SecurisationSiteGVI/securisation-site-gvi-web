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
@RequestScoped 
public class GererSecteurManagedBean {

    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private Secteur secteurSelected;
    
    private Secteur secteur = new Secteur();
    public void addSecteur(){
        try {
            this.secteurSrv.add(getSecteur());
            this.setSecteur(null);
            BoiteAOutils.addMessage("Succes", " Le secteur à bien été ajouté.", "succesListSecteur");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de ajouter le secteur.", "errorListSecteur");
            Logger.getLogger(GererSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeSecteur(){
        try {
            this.secteurSrv.remove(this.secteurSelected);
            BoiteAOutils.addMessage("Succes", " Le secteur à bien été supprimé.", "succesListSecteur");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de supprimé le secteur.", "errorListSecteur");
            Logger.getLogger(GererSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Secteur> getSecteurs() {
        List<Secteur> secteurs = null;
        try {
            secteurs = this.secteurSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " imossible de récupéré la liste des secteurs.", "errorListSecteur");
            Logger.getLogger(GererSecteurManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secteurs;
    }
//
//    public void viewDevicesInSecteur() {
//        List<BorneAcces> borneAcceses = null;
//        List<Camera> camera = null;
//        List<DetecteurIntrusion> detecteurIntrusions = null;
//        if (this.secteurSelected != null) {
//            AttributionSecteurBorneAcces attributionSecteurBorneAcces = attributionSecteurBorneAccesSrv.getBySecteur(secteurSelected);
//            if (!attributionSecteurBorneAcces.getBorneAccess().isEmpty()) {
//                borneAcceses = attributionSecteurBorneAcces.getBorneAccess();
//            }
//            AttributionSecteurCamera attributionSecteurCamera = this.attributionSecteurCameraSrv.getBySecteur(secteurSelected);
//            if (attributionSecteurCamera.getCameras() != null) {
//                camera = attributionSecteurCamera.getCameras();
//            }
//            AttributionSecteurDetecteurIntrusion attributionSecteurDetecteurIntrusion = this.attributionSecteurDetecteurIntrusionSrv.getBySecteur(secteurSelected);
//            if (attributionSecteurDetecteurIntrusion.getDetecteurIntrusions() != null) {
//                detecteurIntrusions = attributionSecteurDetecteurIntrusion.getDetecteurIntrusions();
//            }
//            this.objectsInSecteur = null;
//            if (borneAcceses != null) {
//                objectsInSecteur.addAll(borneAcceses);
//            }
//            if (camera != null) {
//                objectsInSecteur.addAll(camera);
//            }
//            if (detecteurIntrusions != null) {
//                objectsInSecteur.addAll(detecteurIntrusions);
//            }
//        }
//    }

    

    public Secteur getSecteurSelected() {
        return secteurSelected;
    }

    public void setSecteurSelected(Secteur secteurSelected) {
        this.secteurSelected = secteurSelected;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }


}
