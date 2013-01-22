/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import metier.MetierFactory;
import metier.UtilisateurService;
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
}
