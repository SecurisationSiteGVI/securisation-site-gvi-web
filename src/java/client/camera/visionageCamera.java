package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Camera;
import metier.entitys.Photo;
import physique.io.CameraDriver;
import physique.io.PhysiqueIOFactory;




/**
 *
 * @author marvin
 */
@ManagedBean
@ViewScoped
public class visionageCamera {

    private String queryCurrent;
    private Camera selectedCamera;
    private String ip;

    public visionageCamera() {
    }

    public void cameraSelected(ValueChangeEvent evt) {
        System.out.println("Caméra changed");
        Camera c = (Camera) evt.getNewValue();
        CameraDriver drv = physique.io.PhysiqueIOFactory.getCameraDrivers(c);

        String query = "";
        try {
            query = drv.getVideo();
        } catch (Exception ex) {
            Logger.getLogger(visionageCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.queryCurrent = query;
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("camera", c.getIp());
    }

    public void photo() throws FileNotFoundException, IOException, Exception {
        CameraDriver cameraDrivers = PhysiqueIOFactory.getCameraDrivers(selectedCamera);
        byte[] buff = cameraDrivers.prendrePhoto();
        Photo photo = new Photo();
        photo.setDateEvt(new Date());
        photo.setImage(buff);
        photo.setCamera(selectedCamera);
        
        // com
        
        

        EvenementService es = MetierFactory.getEvenementService();

        es.add(photo);
        System.out.println("envoye");

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
