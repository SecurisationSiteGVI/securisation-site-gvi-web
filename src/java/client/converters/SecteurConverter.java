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
import metier.MetierFactory;
import metier.SecteurService;
import metier.entitys.Secteur;

/**
 *
 * @author damien
 */
public class SecteurConverter implements Converter{
    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        boolean trouve = false;
        int i = 0;
        List<Secteur> secteurs=null;
        try {
            secteurs = secteurSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(PositionConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Secteur secteur =null;
        while(trouve!=true){
            secteur = secteurs.get(i);
            if (string.equals(secteur.toString())){
                trouve = true;
            }
            i++;
        }
        return secteur;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Secteur secteur = (Secteur) o;
        return  secteur.toString();
    }
    
}
