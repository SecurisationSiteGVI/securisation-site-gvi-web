/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.File;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author damien
 */
@ManagedBean
public class CSSActive {

    private String active = "active";
    private String url;
    private String pageTechnicien = " ";
    private String histrorique=" ";
    public CSSActive() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.url = context.getViewRoot().getViewId();
        this.url = url.substring(1);
        if("pageTechnicien.xhtml".equals(url)){
            this.pageTechnicien = "active";
        }if("histrorique.xhtml".equals(url)){
            this.histrorique = "active";
        }
       
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageTechnicien() {
        return pageTechnicien;
    }

    public void setPageTechnicien(String pageTechnicien) {
        this.pageTechnicien = pageTechnicien;
    }

    public String getHistrorique() {
        return histrorique;
    }

    public void setHistrorique(String histrorique) {
        this.histrorique = histrorique;
    }
}
