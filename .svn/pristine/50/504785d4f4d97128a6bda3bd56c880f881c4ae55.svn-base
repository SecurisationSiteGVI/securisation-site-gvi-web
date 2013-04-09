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
import metier.DetecteurIntrusionService;
import metier.MetierFactory;
import metier.entitys.DetecteurIntrusion;

/**
 *
 * @author damien
 */
public class DetecteurIntrusionConverter implements Converter{
    private DetecteurIntrusionService detecteurIntrusionSrv = MetierFactory.getDetecteurIntrusionService();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        boolean trouve = false;
        int i = 0;
        List<DetecteurIntrusion> detecteurIntrusions=null;
        try {
            detecteurIntrusions = detecteurIntrusionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusion.class.getName()).log(Level.SEVERE, null, ex);
        }
        DetecteurIntrusion detecteurIntrusion =null;
        while(trouve!=true){
            detecteurIntrusion = detecteurIntrusions.get(i);
            if (string.equals(detecteurIntrusion.toString())){
                trouve = true;
            }
            i++;
        }
        return detecteurIntrusion;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        DetecteurIntrusion detecteurIntrusion = (DetecteurIntrusion) o;
        return  detecteurIntrusion.toString();
    }
    
}

