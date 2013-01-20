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
@ManagedBean(name = "utilisateurManagedBean")
@RequestScoped
public class UtilisateurManagedBean {
    private Utilisateur utilisateur =new Utilisateur();
    private UtilisateurService utilisateurSrv= MetierFactory.getUtilisateurService();
    private Number number;
    public void addUtilisateur(){
        try{
           utilisateurSrv.add(utilisateur); 
           BoiteAOutils.addMessage("Ajout effectué", "l'utilisateur est bien ajouté", "sucssesUser");
           this.utilisateur =null;
        }catch(Exception ex){
            BoiteAOutils.addMessage("Problème lors de l'ajout", "l'utilisateur n'a pas été ajouté", "errorUser");
            System.out.println(ex);
        }
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }
    
    
  
}
