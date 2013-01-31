/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.appareils;

import client.BoiteAOutils;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.PositionService;
import metier.entitys.Position;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class GererPositionManagedBean {

    private PositionService positionSrv = MetierFactory.getPositionService();
    private Position position = new Position();
    public GererPositionManagedBean() {
    }
    public void addPosition(){//succesPosition // errorPosition
        try {
            this.positionSrv.add(position);
            this.position = null;
            BoiteAOutils.addMessage("Succès", " la position à bien été ajouté." , "succesPosition");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " la position n'a pas pu étre ajouté." , "errorPosition");
            Logger.getLogger(GererPositionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
