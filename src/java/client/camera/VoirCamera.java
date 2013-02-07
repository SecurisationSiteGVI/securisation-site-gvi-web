package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import metier.entitys.Camera;

/**
 *
 * @author marvin
 */
@ManagedBean
@ViewScoped
public class VoirCamera {
    private String queryCurrent;
    private String protocol = "http://";
    private String sufixHeden = "/videostream.cgi?user=admin&pwd=marvin&resolution=32";
    private Camera valeurCB;
    
    public VoirCamera() {
    }

  
    public void cameraSelected(ValueChangeEvent evt){
        System.out.println("Caméra changed");
        Camera c = (Camera) evt.getNewValue();
        System.out.println(c.toString());
        String query = this.protocol + c.getIp() + this.sufixHeden;
        this.queryCurrent = query;
        
    }

    /**
     * @return the valeurCB
     */
    public Camera getValeurCB() {
        return valeurCB;
    }

    /**
     * @param valeurCB the valeurCB to set
     */
    public void setValeurCB(Camera valeurCB) {
        this.valeurCB = valeurCB;
    }

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
}
