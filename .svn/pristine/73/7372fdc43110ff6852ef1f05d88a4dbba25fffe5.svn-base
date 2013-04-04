/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.BorneAccesService;
import metier.MetierFactory;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class StartApp {

    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    public void startThread() {
        this.borneAccesSrv.startThread();
    }
}
