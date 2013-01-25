/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Technicien;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class AddUtilisateurManagedBean {

    private Utilisateur utilisateur = new Utilisateur();
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    private String login;
    private String password;
    private String password2;

    public void add(){
        try {
            utilisateurSrv.add(getUtilisateur());
            BoiteAOutils.addMessage("Ajout effectué", "l'utilisateur est bien ajouté", "sucssesUser");
            this.setUtilisateur(null);
        } catch (Exception ex) {
            BoiteAOutils.addMessage("Problème lors de l'ajout", "l'utilisateur n'a pas été ajouté", "errorUser");
            System.out.println(ex);
        }
    }
      
   
    public AddUtilisateurManagedBean() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public void addTechnicien() {
        if (this.getLogin() != null) {
            if (this.getPassword() != null) {
                if (this.getPassword().equals(this.getPassword2())) {
                    Technicien u = new Technicien();
                    u.setAdresse(this.utilisateur.getAdresse());
                    u.setNom(this.utilisateur.getNom());
                    u.setPrenom(this.utilisateur.getPrenom());
                    u.setCodePostale(this.utilisateur.getCodePostale());
                    u.setDateDeNaissance(this.utilisateur.getDateDeNaissance());
                    u.setEmail(this.utilisateur.getEmail());
                    u.setHomme(this.utilisateur.isHomme());
                    u.setLogin(this.getLogin());
                    u.setPassword(this.getPassword());
                    u.encode(true);
                    u.setTelephoneFixe(this.utilisateur.getTelephoneFixe());
                    u.setTelephonePortable(this.utilisateur.getTelephonePortable());
                    u.setVille(this.utilisateur.getVille());
                    utilisateurSrv.add(u);
                } else {
                    BoiteAOutils.addMessage("Erreur", " les mot de passe ne corespondent pas", "errorUser");
                }

            } else {
                BoiteAOutils.addMessage("Erreur", " entrer un mot de passe", "errorUser");
            }
        } else {
            BoiteAOutils.addMessage("Erreur", " entrer un login", "errorUser");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
}
