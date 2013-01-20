/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author damien
 */
public class BoiteAOutils {

    public static boolean testEmail(String email) {
        Boolean retour = false;
        Pattern pattern = Pattern.compile("^[_a-z0-9-]+[^0]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            retour = false;
        } else {
            retour = true;
        }
        return retour;
    }

    public static boolean testTelephone(String telephone) {
        Boolean retour = false;
        if (telephone.length() == 10) {
            Pattern pattern = Pattern.compile("^0[0-68]([-. ]?\\d{2}){4}[-. ]?$");
            Matcher matcher = pattern.matcher(telephone);
            if (!matcher.matches()) {
                retour = true;
            } else {
                retour = false;
            }
        }
        return retour;
    }

    public static FacesMessage addMessage(String summary) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage();
        fm.setSummary(" " + summary);
        fm.setDetail(" ");
        fm.setSeverity(FacesMessage.SEVERITY_WARN);
        fc.addMessage("a", fm);
        return fm;
    }

    public static FacesMessage addMessage(String summary, String details) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage();
        fm.setSummary(" " + summary);
        fm.setDetail(details);
        fm.setSeverity(FacesMessage.SEVERITY_WARN);
        fc.addMessage("a", fm);
        return fm;
    }

    public static FacesMessage addMessage(String summary, String details, String id) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage fm = new FacesMessage();
        fm.setSummary(" " + summary);
        fm.setDetail(details);
        fm.setSeverity(FacesMessage.SEVERITY_WARN);
        fc.addMessage(id, fm);
        return fm;
    }
    
}
