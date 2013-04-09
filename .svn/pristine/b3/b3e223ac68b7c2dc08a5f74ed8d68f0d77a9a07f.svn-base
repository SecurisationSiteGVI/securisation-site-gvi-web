/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.converters;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import metier.CameraService;
import metier.MetierFactory;
import metier.entitys.Camera;

/**
 *
 * @author marvin
 */
public class CameraConverter implements Converter{
    private CameraService cameraSrv = MetierFactory.getCameraService();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        boolean trouve = false;
        int i = 0;
        List<Camera> cameras=null;
        try {
            cameras = cameraSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CameraConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Camera camera =null;
        while(trouve!=true){
            camera = cameras.get(i);
            if (string.equals(camera.toString())){
                trouve = true;
            }
            i++;
        }
        return camera;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Camera position = (Camera) o;
        return  position.toString();
    }
    
}
