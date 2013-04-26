/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.authorisationAcces;

import client.BoiteAOutils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import metier.AuthorisationAccesService;
import metier.MetierFactory;
import metier.SecteurService;
import metier.UtilisateurService;
import metier.entitys.AuthorisationAcces;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean
@ViewScoped
public class AuthorisationAccesManagedBean {

    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private List<Secteur> secteurs;
    private SecteurIsAttribuer secteurSelected;
    private List<Object> objects = new ArrayList<Object>();
    private String textFilter = new String();
    private int indexUtilisateur;
    private int nbResult = 10;
    private List<Utilisateur> utilisateurs;
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private Utilisateur utilisateurSelected;
    private String heureOuverture = new String();
    private String minutesOuverture = new String();
    private String heureFermetre = new String();
    private String minutesFermeture = new String();
    private AuthorisationAccesService authorisationAccesSrv = MetierFactory.getAuthorisationAccesService();
//succesAuthorisationAcces  errorAuthorisationAcces 

    public void selectionerUtilisateur() {
        boolean trouve = false;
        int pos = 0;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) instanceof Utilisateur) {
                trouve = true;
                pos = i;
            }
        }
        if (trouve == true) {
            this.objects.remove(pos);
            this.objects.add(pos, this.utilisateurSelected);
        } else {
            this.objects.add(this.utilisateurSelected);
        }
    }

    public List<SecteurIsAttribuer> getSecteurWithUtilisateurSelected() {

        List<Secteur> secteurs = null;
        List<SecteurIsAttribuer> secteurIsAttribuers = new ArrayList<SecteurIsAttribuer>();
        if (this.utilisateurSelected != null) {
            List<Secteur> secteursIsUse = authorisationAccesSrv.getSecteurNotAssignByUtilisateur(this.utilisateurSelected);
            for (int i = 0; i < secteursIsUse.size(); i++) {
                SecteurIsAttribuer a = new SecteurIsAttribuer();
                a.setAtribuer(false);
                a.setSecteur(secteursIsUse.get(i));
                secteurIsAttribuers.add(a);
            }
            AuthorisationAcces authorisationAcces = null;
            try {
                authorisationAcces = this.authorisationAccesSrv.getByUtilisateur(this.utilisateurSelected);
            } catch (Exception ex) {
                Logger.getLogger(AuthorisationAccesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (authorisationAcces != null) {
                for (int i = 0; i < authorisationAcces.getSecteurs().size(); i++) {
                    SecteurIsAttribuer a = new SecteurIsAttribuer();
                    a.setAtribuer(true);
                    a.setSecteur(authorisationAcces.getSecteurs().get(i));
                    secteurIsAttribuers.add(a);
                }
                if (authorisationAcces.getHeureFermeture() != null) {
                    this.setHeureFermetre(String.valueOf(authorisationAcces.getHeureFermeture().getHours()));
                    this.setMinutesFermeture(String.valueOf(authorisationAcces.getHeureFermeture().getMinutes()));
                } else {
                    this.setHeureFermetre(String.valueOf(0));
                    this.setMinutesFermeture(String.valueOf(0));
                }
                if (authorisationAcces.getHeureOuverture() != null) {
                    this.setHeureOuverture(String.valueOf(authorisationAcces.getHeureOuverture().getHours()));
                    this.setMinutesOuverture(String.valueOf(authorisationAcces.getHeureOuverture().getMinutes()));
                } else {
                    this.setHeureOuverture(String.valueOf(0));
                    this.setMinutesOuverture(String.valueOf(0));
                }
            }
        }
        return secteurIsAttribuers;
    }

    public void pagePrécédente() {
        if (this.indexUtilisateur <= nbResult - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorPageutili");
        } else {
            this.indexUtilisateur = this.indexUtilisateur - nbResult;
        }
    }

    public void authoriser() {
        AuthorisationAcces authorisationAcces = null;
        boolean neww = false;
        try {
            if (this.authorisationAccesSrv.getByUtilisateur(utilisateurSelected) == null) {
                authorisationAcces = new AuthorisationAcces();
                neww = true;
            } else {
                authorisationAcces = this.authorisationAccesSrv.getByUtilisateur(this.getUtilisateurSelected());
            }
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date fermeture = new Date();
        if (this.heureFermetre.isEmpty() && this.minutesFermeture.isEmpty()) {
            fermeture.setHours(0);
            fermeture.setMinutes(0);
        } else {
            fermeture.setHours(Integer.parseInt(this.heureFermetre));
            fermeture.setMinutes(Integer.parseInt(this.minutesFermeture));
        }
        Date ouverture = new Date();
        if (this.heureOuverture.isEmpty() && this.minutesOuverture.isEmpty()) {
            ouverture.setHours(0);
            ouverture.setMinutes(0);
        } else {
            ouverture.setHours(Integer.parseInt(this.heureOuverture));
            ouverture.setMinutes(Integer.parseInt(this.minutesOuverture));
        }
        List<Secteur> secteurs = new ArrayList<Secteur>();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) instanceof SecteurIsAttribuer) {
                SecteurIsAttribuer ie = (SecteurIsAttribuer) objects.get(i);
                secteurs.add(ie.getSecteur());
                objects.remove(i);
            }
        }
        if (!secteurs.isEmpty()) {
            if (authorisationAcces.getSecteurs() == null) {
                List<Secteur> q = new ArrayList<Secteur>();
                q.addAll(secteurs);
                authorisationAcces.setSecteurs(q);
            }

        }
        authorisationAcces.setHeureFermeture(fermeture);
        authorisationAcces.setHeureOuverture(ouverture);
        authorisationAcces.setUtilisateur(utilisateurSelected);
        if (neww) {
            try {
                this.authorisationAccesSrv.add(authorisationAcces);
            } catch (Exception ex) {
                Logger.getLogger(AuthorisationAccesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                this.authorisationAccesSrv.update(authorisationAcces);
            } catch (Exception ex) {
                Logger.getLogger(AuthorisationAccesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void filtrer() {
        this.indexUtilisateur = 0;
    }

    public void pageSuivant() {
        this.indexUtilisateur = this.indexUtilisateur + nbResult;
    }

    public AuthorisationAccesManagedBean() {//succesAuthorisationAcces
        this.indexUtilisateur = 0;
        try {
            this.secteurs = this.secteurSrv.getAll();
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de récupérer la liste des secteurs", "errorAuthorisationAcces");
            Logger.getLogger(AuthorisationAccesManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Utilisateur> getUtilisateurs() {
        if (this.getTextFilter().length() >= 1) {
            this.utilisateurs = this.utilisateurSrv.getByNom(this.getTextFilter(), this.indexUtilisateur, this.nbResult);
        } else {
            this.utilisateurs = this.utilisateurSrv.getAllByRange(this.indexUtilisateur, this.nbResult);
        }
        return utilisateurs;
    }

    public int getPage() {
        int page = this.indexUtilisateur / this.nbResult;
        return page;

    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

//    public void selectionnerSecteur() {
//        boolean trouve = false;
//        int pos = 0;
//        for (int i = 0; i < objects.size(); i++) {
//            if (objects.get(i) instanceof Secteur) {
//                trouve = true;
//                pos = i;
//            }
//        }
//        if (this.secteurSelected.isAtribuer() == false) {
//            if (trouve == true) {
//                this.objects.remove(pos);
//                this.objects.add(pos, this.secteurSelected);
//            } else {
//                this.objects.add(this.secteurSelected);
//            }
//        } else {
//            this.detacherSecteurFormUtilisateur();
//        }
//
//    }
    public void selectionnerSecteur() {
        if (this.utilisateurSelected != null) {
            if (this.secteurSelected.isAtribuer()) {
                this.detacherSecteurFormUtilisateur();
            } else {
                this.attacherSecteurFromUtilisateur();
            }
        } else {
            BoiteAOutils.addMessage("Erreur", " veuiller selectionner d'abord l'utilsateur", "errorAuthorisationAcces");
        }
    }

    public void attacherSecteurFromUtilisateur() {
        this.authorisationAccesSrv.atacherSecteurFromUtilisateur(this.secteurSelected.getSecteur(), this.utilisateurSelected);
    }

    public void detacherSecteurFormUtilisateur() {
        this.authorisationAccesSrv.detacherSecteurFromUtilisateur(this.secteurSelected.getSecteur(), this.utilisateurSelected);
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public SecteurIsAttribuer getSecteurSelected() {
        return secteurSelected;
    }

    public void setSecteurSelected(SecteurIsAttribuer secteurSelected) {
        this.secteurSelected = secteurSelected;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public Utilisateur getUtilisateurSelected() {
        return utilisateurSelected;
    }

    public void setUtilisateurSelected(Utilisateur utilisateurSelected) {
        this.utilisateurSelected = utilisateurSelected;
    }

    public String getTextFilter() {
        return textFilter;
    }

    public void setTextFilter(String textFilter) {
        this.textFilter = textFilter;
    }

    public String getHeureOuverture() {
        return heureOuverture;
    }

    public void setHeureOuverture(String heureOuverture) {
        this.heureOuverture = heureOuverture;
    }

    public String getMinutesOuverture() {
        return minutesOuverture;
    }

    public void setMinutesOuverture(String minutesOuverture) {
        this.minutesOuverture = minutesOuverture;
    }

    public String getHeureFermetre() {
        return heureFermetre;
    }

    public void setHeureFermetre(String heureFermetre) {
        this.heureFermetre = heureFermetre;
    }

    public String getMinutesFermeture() {
        return minutesFermeture;
    }

    public void setMinutesFermeture(String minutesFermeture) {
        this.minutesFermeture = minutesFermeture;
    }
}
