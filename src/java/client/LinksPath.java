/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author damien
 */
@ManagedBean(name="linkPath")
public class LinksPath {
    private String protocol ="http://";
    private String host ="localhost:8080";
    private String applicationName = "securisation-site-gvi-web";
    private String repertoire ="css";
    private String path = this.protocol+this.host+"/"+this.applicationName+"/"+this.repertoire;
    private String pathLink= this.protocol+this.host+"/"+this.applicationName;
    public String getCssStyle(){
        String style = this.path+"/style.css";
        return style;
    }
    public String getCssStyle1(){
        String style = this.path+"/style1.css";
        return style;
    }
    public String getCssStylebMin(){
        String style = this.path+"/styleb-min.css";
        return style;
    }
    public String getCssStyle1Min(){
        String style = this.path+"/style1-min.css";
        return style;
    }
    public String getCssStyleb(){
        String style = this.path+"/styleb.css";
        return style;
    }
    public String getCssDocs(){
        String style = this.path+"/docs.css";
        return style;
    }

    public String getPathLink() {
        return pathLink;
    }

}
