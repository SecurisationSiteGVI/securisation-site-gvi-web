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
@ManagedBean(name = "linkPath")
public class LinksPath {

    private static String protocol = "http://";
    private static String host = "localhost:8080";
    private static String applicationName = "securisation-site-gvi-web";
    private static String repertoire = "css";
    private static String path = LinksPath.protocol + LinksPath.host + "/" + LinksPath.applicationName + "/" + LinksPath.repertoire;
    private static String pathLink = LinksPath.protocol + LinksPath.host + "/" + LinksPath.applicationName;

    public static String getTechnicienNonConnecte() {
        String error = LinksPath.pathLink + "/errorPages/pageTechnicienNonConnect.jsf";
        return error;
    }

    public String getCssStyle() {
        String style = LinksPath.path + "/style.css";
        return style;
    }

    public String getCssStyle1() {
        String style = LinksPath.path + "/style1.css";
        return style;
    }

    public String getCssStylebMin() {
        String style = LinksPath.path + "/styleb-min.css";
        return style;
    }

    public String getCssStyle1Min() {
        String style = LinksPath.path + "/style1-min.css";
        return style;
    }

    public String getCssStyleb() {
        String style = LinksPath.path + "/styleb.css";
        return style;
    }

    public String getCssDocs() {
        String style = LinksPath.path + "/docs.css";
        return style;
    }

    public String getPathLink() {
        return pathLink;
    }
}
