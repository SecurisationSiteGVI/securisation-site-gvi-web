/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Evenement;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class HistoriqueManagedBean {

    private List<Evenement> evenements;
    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    private int index;
    private int nbResult =10;
    public HistoriqueManagedBean() {
        this.index =0;
        this.evenements = evenementSrv.getAll(this.index, this.nbResult);
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
