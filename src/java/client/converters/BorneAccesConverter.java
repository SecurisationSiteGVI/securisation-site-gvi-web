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
import metier.BorneAccesService;
import metier.MetierFactory;
import metier.entitys.BorneAcces;

/**
 *
 * @author damien
 */
public class BorneAccesConverter  implements Converter{
    private BorneAccesService cameraSrv = MetierFactory.getBorneAccesService();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        boolean trouve = false;
        int i = 0;
        List<BorneAcces> borneAcceses=null;
        try {
            borneAcceses = cameraSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(BorneAcces.class.getName()).log(Level.SEVERE, null, ex);
        }
        BorneAcces borneAcces =null;
        while(trouve!=true){
            borneAcces = borneAcceses.get(i);
            if (string.equals(borneAcces.toString())){
                trouve = true;
            }
            i++;
        }
        return borneAcces;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        BorneAcces borneAcces = (BorneAcces) o;
        return  borneAcces.toString();
    }
    
}

