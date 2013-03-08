/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Acces;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;
import metier.entitys.Photo;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class HistoriqueManagedBean {

    private List<Evenement> evenements;
    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    private Object objectSelected;
    private Acces accesView;
    private Intrusion intrusionView;
    private Photo photoView;
    private int index;
    private int nbLinge = 10;

    public HistoriqueManagedBean() {
        this.index = 0;
        this.evenements = evenementSrv.getByMostRecent(this.index, this.nbLinge);
    }

    public void more() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.setAttribute("historique", this.objectSelected);
        if (objectSelected instanceof Photo) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(LinksPath.getPathLinkStatic() + "/historique/photo.jsf");
            } catch (IOException ex) {
                Logger.getLogger(HistoriqueManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (objectSelected instanceof Acces) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(LinksPath.getPathLinkStatic() + "/historique/acces.jsf");
            } catch (IOException ex) {
                Logger.getLogger(HistoriqueManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (objectSelected instanceof Intrusion) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(LinksPath.getPathLinkStatic() + "/historique/intrusion.jsf");
            } catch (IOException ex) {
                Logger.getLogger(HistoriqueManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void pageSuivant() {
        this.index = this.index + nbLinge;
    }

    public void pagePrécédente() {
        if (this.index <= nbLinge - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorPageutili");
        } else {
            this.index = this.index - nbLinge;
        }
    }
    public List<Evenement> getEvenements() {
        this.evenements = this.evenementSrv.getByMostRecent(this.index, this.nbLinge);
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }

    public Object getObjectSelected() {
        return objectSelected;
    }

    public void setObjectSelected(Object objectSelected) {
        this.objectSelected = objectSelected;
    }

    public int getPage() {
        int page = index / nbLinge;
        page = page+1;
        return page;

    }
    public void retour() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(LinksPath.getPathLinkStatic() + "/histrorique.jsf");
        } catch (IOException ex) {
            Logger.getLogger(HistoriqueManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Acces getAccesView() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Acces s = null;
        if (session.getAttribute("historique") != null) {
            s = (Acces) session.getAttribute("historique");
            this.accesView = s;
        }
        return accesView;
    }

    public void setAccesView(Acces accesView) {
        this.accesView = accesView;
    }

    public Intrusion getIntrusionView() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Intrusion s = null;
        if (session.getAttribute("historique") != null) {
            s = (Intrusion) session.getAttribute("historique");
            this.intrusionView = s;
        }
        return intrusionView;
    }

    public void setIntrusionView(Intrusion intrusionView) {
        this.intrusionView = intrusionView;
    }

    public Photo getPhotoView() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Photo s = null;
        if (session.getAttribute("historique") != null) {
            s = (Photo) session.getAttribute("historique");
            this.photoView = s;
        }
        return photoView;
    }

    public void setPhotoView(Photo photoView) {
        this.photoView = photoView;
    }
}
