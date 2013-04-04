/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.appareils;

import client.BoiteAOutils;
import java.util.List;
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
    private List<Position> positions;
    private Position positionSelected;
    
    public GererPositionManagedBean() {
    }
    public void addPosition(){
        try {
            this.positionSrv.add(position);
            this.position = null;
            BoiteAOutils.addMessage("Succès", " la position à bien été ajouté." , "succesPosition");
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " la position n'a pas pu étre ajouté." , "errorPosition");
            Logger.getLogger(GererPositionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removePosition(){
        if(this.positionSelected!=null){
            try {
                this.positionSrv.remove(this.positionSelected);
                BoiteAOutils.addMessage("Succès", " la position à bien été supprimé." , "succesPosition");
            } catch (Exception ex) {
                BoiteAOutils.addMessage("Erreur", " la position n'a pas pu étre supprimé." , "errorPosition");
                Logger.getLogger(GererPositionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Position> getPositions() {
        try {
            this.positions = this.positionSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupéré la liste des positions." , "errorPosition");
            Logger.getLogger(GererPositionManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Position getPositionSelected() {
        return positionSelected;
    }

    public void setPositionSelected(Position positionSelected) {
        this.positionSelected = positionSelected;
    }
}
