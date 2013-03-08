package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import physique.io.CameraDriver;

/**
 *
 * @author marvin
 */
@ManagedBean
@ViewScoped
public class visionageCameraHEDEN {
    private String queryCurrent;
    private Camera selectedCamera;
    
    public visionageCameraHEDEN() {
    }

  
    public void cameraSelected(ValueChangeEvent evt){
        System.out.println("Caméra changed");
        Camera c = (Camera) evt.getNewValue();
        CameraDriver drv = physique.io.PhysiqueIOFactory.getCameraDrivers(c);
        
        String query = "";
        try {
            query = drv.getVideo();
        } catch (Exception ex) {
            Logger.getLogger(visionageCameraHEDEN.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.queryCurrent = query;
         HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("camera", c.getIp());
    }

        public void photo() throws FileNotFoundException, IOException{
        
        
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        FileOutputStream fos = new FileOutputStream("/home/blondellemarvin/Bureau/photo.jpg");
        
        DefaultHttpClient client2 = new DefaultHttpClient();
        HttpGet request2 = new HttpGet("http://172.16.79.214/snapshot.jpg?user=admin&pwd=marvin");
        HttpResponse response2 = client2.execute(request2);

        BufferedInputStream is = new BufferedInputStream(response2.getEntity().getContent());

        byte[] buff = new byte[10240];
        int n;
        int total = 0;
        while ((n = is.read(buff)) != -1) {
            if( n >= buff.length) {
                n = buff.length-1;
            }
            
            bos.write(buff, 0, n);
            fos.write(buff, 0, n);
 
            total += n;
               
        }
        System.out.println("IMG : " + total);
        fos.close();
        bos.close();
        is.close();
        //response.getWriter().print("ok");
        
        Photo photo = new Photo();
        photo.setDateEvt(new Date());
        photo.setImage(buff);

        EvenementService es= MetierFactory.getEvenementService();
        try {
            es.add(photo);
            System.out.println("envoye");
        } catch (Exception ex) {
            Logger.getLogger(Capture.class.getName()).log(Level.SEVERE, null, ex);
        }
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
