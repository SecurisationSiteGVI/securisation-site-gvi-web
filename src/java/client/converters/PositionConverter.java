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
import metier.PositionService;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
public class PositionConverter implements Converter{
    private PositionService positionSrv = MetierFactory.getPositionService();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        boolean trouve = false;
        int i = 0;
        List<Position> positions=null;
        try {
            positions = positionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(PositionConverter.class.getName()).log(Level.SEVERE, null, ex);
        }
        Position position =null;
        while(trouve!=true){
            position = positions.get(i);
            if (string.equals(position.toString())){
                trouve = true;
            }
            i++;
        }
        return position;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Position position = (Position) o;
        return  position.toString();
    }
    
}
