/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.numeroTelephone;

import client.BoiteAOutils;
import client.google.Contact;
import client.google.GoogleContacts;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.security.sasl.AuthenticationException;

/**
 *
 * @author damien
 */
@ManagedBean
@ViewScoped
public class NumeroPredefiniManagedBean {

    private List<Contact> contacts = new ArrayList<Contact>();
    private String email = new String();
    private String password = new String();
    private List<Contact> contactsPagination = new ArrayList<Contact>();
    private int index;
    private int nbResult = 10;
//succesNumero  errorNumero
    public NumeroPredefiniManagedBean() {
        this.index = 0;
    }

    public void pagePrécédente() {
        if (this.index <= nbResult - 1) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "Vous éte déjà sur la premiere page", "errorNumero");
        } else {
            this.index = this.index - nbResult;
            addToConctactPagination(this.index, this.nbResult);
        }
    }

    public void pageSuivant() {
        if(this.contacts.size()>(this.index-this.nbResult)){
            this.index = this.index + nbResult;
        addToConctactPagination(this.index, this.nbResult);
        }
        
    }

    public void listerContacts() {
        try {
            GoogleContacts gc = new GoogleContacts();
            this.setContacts(gc.getGoogleContacts(getEmail(), getPassword()));
            addToConctactPagination(0, this.nbResult);
        } catch (com.google.gdata.util.AuthenticationException ex) {
            BoiteAOutils.addMessage("Erreur", " login ou mot de passe incorrect", "errorNumero");
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            BoiteAOutils.addMessage("Impossible d'éffectuer", "impossible de se conncter à la base de donée de google", "errorNumero");
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AuthenticationException ex) {
            BoiteAOutils.addMessage("Erreur", " login ou mot de passe incorrect", "errorNumero");
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            BoiteAOutils.addMessage("Erreur", " mauvais format d'url", "errorNumero");
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            BoiteAOutils.addMessage("Erreur", " impossible de se connecter a internet", "errorNumero");
            Logger.getLogger(NumeroPredefiniManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToConctactPagination(int index, int nbResult) {
        if (!this.contacts.isEmpty()) {
            if (!this.contactsPagination.isEmpty()) {
                for (int i = 0; i < this.contactsPagination.size(); i++) {
                    this.contactsPagination.removeAll(this.contactsPagination);
                }
            }
            for (int i = index; i < (this.nbResult+this.index); i++) {
                
                this.contactsPagination.add(this.contacts.get(i));
            }
        }

    }

    public void suppresEmail() {
        for (int i = 0; i < this.contacts.size(); i++) {

            if (this.contacts.get(i).getTel() == null) {
                this.contacts.remove(i);
            }
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Contact> getContactsPagination() {
        //addToConctactPagination(index, nbResult);
        return contactsPagination;
    }

    public void setContactsPagination(List<Contact> contactsPagination) {
        this.contactsPagination = contactsPagination;
    }
}
