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
import javax.faces.model.SelectItem;
import metier.CameraService;
import metier.MetierFactory;
import metier.PositionService;
import metier.entitys.Camera;
import metier.entitys.Position;
import metier.entitys.TypeCamera;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public final class CameraManagedBean {

    private CameraService cameraSrv = MetierFactory.getCameraService();
    private Camera camera = new Camera();
    private Camera cameraSelected;
    private String[] typeCamera ;
    
    public CameraManagedBean() {
//        List<Camera>  cameras = this.getCameras();
//        if (cameras != null) {
//            if (!cameras.isEmpty()) {
//                this.camera = cameras.get(0);
//            }
//        }
    }
    public void addCamera(){
        try {
            cameraSrv.add(camera);
            this.camera = null;
            BoiteAOutils.addMessage("Succes", "Caméra bien crée.", "succesCamera");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de ajouter une caméra.", "errorCamera");
            Logger.getLogger(CameraManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Position> getPositions() {
        PositionService positionSrv = MetierFactory.getPositionService();
        List<Position> positions = null;
        try {
            positions = positionSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste des positions.", "errorCamera");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return positions;
    }

    public void removeCamera(){
        try {
            this.cameraSrv.remove(this.cameraSelected);
            BoiteAOutils.addMessage("Succes", "Caméra bien supprimé.", "succesCamera");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de supprimé la caméra.", "errorCamera");
            Logger.getLogger(CameraManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Camera> getCameras() {
        List<Camera> cameras = null;
        try {
            cameras = cameraSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste des caméras.", "errorCamera");
            Logger.getLogger(LecteurBadgeManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cameras;
    }
    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Camera getCameraSelected() {
        return cameraSelected;
    }

    public void setCameraSelected(Camera cameraSelected) {
        this.cameraSelected = cameraSelected;
    }

    /**
     * @return the typeCamera
     */
    public String[] getTypeCamera() {
        TypeCamera[] types = TypeCamera.values();
        int lenght = types.length;
        String[] str = new String[lenght];
        for(int i=0; i<lenght;i++){
            str[i] = types[i].toString();
        }return str;
    }

    /**
     * @param typeCamera the typeCamera to set
     */
    public void setTypeCamera(String[] typeCamera) {
        this.typeCamera = typeCamera;
    }
}
