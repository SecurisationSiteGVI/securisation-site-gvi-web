package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import client.BoiteAOutils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import metier.CameraService;
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Camera;
import metier.entitys.Photo;


/**
 *  
 * @author marvin
 */
@ManagedBean
@ViewScoped
public class visionageCameraBean {

    private String queryCurrent;
    private Camera selectedCamera;
    private String ip;

    public visionageCameraBean() {
        try {
            if (!MetierFactory.getCameraService().getAll().isEmpty()) {
                try {
                    this.selectedCamera = MetierFactory.getCameraService().getAll().get(0);
                } catch (Exception ex) {
                    BoiteAOutils.addMessage("Erreur", "Impossible de recuprer la liste des caméras.", "errorVisionageCamera");
                    Logger.getLogger(visionageCameraBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                CameraService cameraService = metier.MetierFactory.getCameraService();
                String query = "";
                try {
                    query = cameraService.getVideo(selectedCamera);
                } catch (Exception ex) {
                    Logger.getLogger(visionageCameraBean.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.queryCurrent = query;
            }
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", "Impossible de recuprer la liste des caméras.", "errorVisionageCamera");
        }
    }

    public void cameraSelected(ValueChangeEvent evt) {
        System.out.println("Caméra changed");
        Camera c = (Camera) evt.getNewValue();
        CameraService cameraService = metier.MetierFactory.getCameraService();

        String query = "";
        try {
            query = cameraService.getVideo(c);
        } catch (Exception ex) {
            Logger.getLogger(visionageCameraBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.queryCurrent = query;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("camera", c.getIp());
    }

    public void photo() throws FileNotFoundException, IOException, Exception {
        CameraService cameraService = metier.MetierFactory.getCameraService();
        byte[] buff = cameraService.prendrePhoto(selectedCamera);
        Photo photo = new Photo();
        photo.setDateEvt(new Date());
        photo.setImage(buff);
        photo.setCamera(selectedCamera);


        EvenementService es = MetierFactory.getEvenementService();

        es.add(photo);
        BoiteAOutils.addMessage("Succes", "Photo bien capturé.", "succesVisionageCamera");

    }

    private void photoCameraSony() {
    }

    public String getIpCurentCamera() {
        return getQueryCurrent();
    }

    /**
     * @param ipCurentCamera the ipCurentCamera to set
     */
    public void setIpCurentCamera(String ipCurentCamera) {
        this.setQueryCurrent(ipCurentCamera);
    }

    /**
     * @return the queryCurrent
     */
    public String getQueryCurrent() {
        return queryCurrent;
    }

    /**
     * @param queryCurrent the queryCurrent to set
     */
    public void setQueryCurrent(String queryCurrent) {
        this.queryCurrent = queryCurrent;
    }

    /**
     * @return the selectedCamera
     */
    public Camera getSelectedCamera() {
        return selectedCamera;
    }

    /**
     * @param selectedCamera the selectedCamera to set
     */
    public void setSelectedCamera(Camera selectedCamera) {
        this.selectedCamera = selectedCamera;
    }
}
