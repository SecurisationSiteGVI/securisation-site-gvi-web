package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpSession;
import metier.entitys.Camera;
import physique.io.CameraDriver;

/**
 *
 * @author marvin
 */
@ManagedBean
@ViewScoped
public class VoirCamera {
    private String queryCurrent;
    private Camera selectedCamera;
    
    public VoirCamera() {
       
    }

  
    public void cameraSelected(ValueChangeEvent evt){
        System.out.println("Caméra changed");
        Camera c = (Camera) evt.getNewValue();
        CameraDriver drv = physique.io.PhysiqueIOFactory.getCameraDrivers(c);
        
        String query = "";
        try {
            query = drv.getVideo();
        } catch (Exception ex) {
            Logger.getLogger(VoirCamera.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.queryCurrent = query;
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("camera", c.getIp());
    }

    /**

    /**
     * @return the ipCurentCamera
     */
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
