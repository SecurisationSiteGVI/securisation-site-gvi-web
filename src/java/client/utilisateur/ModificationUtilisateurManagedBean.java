/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.utilisateur;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@ManagedBean
@RequestScoped
public class ModificationUtilisateurManagedBean {

    private Utilisateur utilisateur=new Utilisateur();
    public ModificationUtilisateurManagedBean() {
        
    }
    

    public Utilisateur getUtilisateur() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        Utilisateur s = null;
        if (session.getAttribute("modification") != null) {
            s = (Utilisateur) session.getAttribute("modification");
            this.utilisateur = s;
        }
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
