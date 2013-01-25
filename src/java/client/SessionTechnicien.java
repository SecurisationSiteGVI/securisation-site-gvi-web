/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Technicien;

/**
 *
 * @author damien
 */
@ManagedBean
@SessionScoped
public class SessionTechnicien {

    private Technicien technicien = new Technicien();
    private String login = new String();
    private String password = new String();
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private String technicienToString;

    public void testDeConnexion() throws IOException {
        this.technicien = this.utilisateurSrv.verifificationConnexion(this.getLogin(), this.getPassword());
        if (this.getTechnicien() == null) {
            BoiteAOutils.addMessage("Votre login ou votre mot de passe est mauveais ", "probléme de connexion", "log");
        } else {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("technicien", this.getTechnicien());
            FacesContext.getCurrentInstance().getExternalContext().redirect("histrorique.jsf");
        }
    }

    public void technicienConnected() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Technicien technicien = null;
        if (session.getAttribute("technicien") != null) {
            technicien = (Technicien) session.getAttribute("technicien");
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(LinksPath.getTechnicienNonConnecte());
            } catch (IOException ex) {
                Logger.getLogger(SessionTechnicien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public Technicien getTechnicien() {
        return technicien;
    }

    public String getTechnicienToString() {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Technicien technicien = null;
        if (session.getAttribute("technicien") != null) {
            technicien = (Technicien) session.getAttribute("technicien");
            technicienToString = technicien.toString();
        }
        return technicienToString;
    }

    public void setTechnicien(Technicien technicien) {
        this.technicien = technicien;
    }

    public String disconnect() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Technicien personne = (Technicien) session.getAttribute("technicien");
        session.setAttribute("technicien", null);
        return "index.jsf";
    }

    public String getLogin() {
        this.login = "damienChes";
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        this.password = "damien";
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
