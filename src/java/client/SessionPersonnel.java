/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;




/**
 *
 * @author damien
 */

public class SessionPersonnel {
//
////    private PersonneService personnelSrv = MetierFacory.getPersonneService();
////    private String login;
////    private String password;
////    private Personne personne;
////    private String affichageBarreEtat;
//
//    public SessionPersonnel() {
//    }
//
//    public void testDeConnexion() {
////        try {
////            
////            this.setPersonne(personnelSrv.verifificationConnexion(login, password));
////        } catch (Exception ex) {
////            Logger.getLogger(SessionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
////        }
//        if (getPersonne() == null) {
//            FacesContext fc = FacesContext.getCurrentInstance();
//            FacesMessage fm = new FacesMessage();
//            fm.setSummary("  Le login ou le mot de passe est incorrect");
//            fm.setDetail("client non connecté");
//            fm.setSeverity(FacesMessage.SEVERITY_WARN);
//            fc.addMessage("a", fm);
//        } else {
//            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            session.setAttribute("personne", getPersonne());
//            setAffichageBarreEtat("Bonjour " + personne.getPrenom() + " " + personne.getNom());
//        }
//    }
//
//    public void initialiseParamPersonneIfConnected() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session.getAttribute("personne") != null) {
//            personne = (Personne) session.getAttribute("personne");
//        }
//
//
//        this.setPersonne(personne);
//    }
//
//    public void clientConnecte() {
//
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session.getAttribute("personne") == null) {
//            try {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("erreurClientNonConnecte.jsf");
//            } catch (IOException ex) {
//                Logger.getLogger(SessionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//    }
//
//    public String clientDeconexion() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = (Personne) session.getAttribute("personne");
//        String labelClient = personne.toString();
//        session.setAttribute("personne", null);
//        this.affichageBarreEtat = null;
//        this.personne = null;
//        System.out.println("Deconnexion ok : " + labelClient);
//        return "index.jsf";
//    }
//
//    public void clientNormalConnecte() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session.getAttribute("personne") != null) {
//            personne = (Personne) session.getAttribute("personne");
//            if (!personne.isIsAdministrateur()) {
//                try {
//                    FacesContext.getCurrentInstance().getExternalContext().redirect("erreurClientNonAdministrateur.jsf");
//                } catch (IOException ex) {
//                    Logger.getLogger(SessionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        } else {
//            try {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("erreurClientNonConnecte.jsf");
//            } catch (IOException ex) {
//                Logger.getLogger(SessionPersonnel.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//
//    public String clientAdministrateurConnecte() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session.getAttribute("personne") != null) {
//            personne = (Personne) session.getAttribute("personne");
//            if (personne.isIsAdministrateur() == false) {
//                return "erreurClientNonAdministrateur.jsf";
//            }
//        }
//        return "";
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public Personne getPersonne() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session != null) {
//            if (session.getAttribute("personne") != null) {
//                personne = (Personne) session.getAttribute("personne");
//                this.personne = personne;
//                this.setAffichageBarreEtat("Bonjour " + personne.getPrenom() + " " + personne.getNom());
//            }
//        }
//
//        return this.personne;
//    }
//
//    public static Personne getPersonneConnecte() {
//        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
//        Personne personne = null;
//        if (session != null) {
//            if (session.getAttribute("personne") != null) {
//                personne = (Personne) session.getAttribute("personne");
//
//            }
//        }
//
//        return personne;
//    }
//
//    public void setPersonne(Personne personne) {
//        this.personne = personne;
//    }
//
//    public String getAffichageBarreEtat() {
//        if (SessionPersonnel.getPersonneConnecte() != null) {
//            Personne p =SessionPersonnel.getPersonneConnecte();
//            setAffichageBarreEtat("Bonjour " + p.getPrenom() + " " + p.getNom());
//        }
//
//        return affichageBarreEtat;
//    }
//
//    public void setAffichageBarreEtat(String affichageBarreEtat) {
//        this.affichageBarreEtat = affichageBarreEtat;
//    }
}
