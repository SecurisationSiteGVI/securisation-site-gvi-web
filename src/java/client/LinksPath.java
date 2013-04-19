/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author damien
 */
@ManagedBean(name = "linkPath")
public class LinksPath {

    private static String protocol = "http://";
    private static String host = "localhost:8084"/*getIps().get(1)+":8084"*/;
    private static String applicationName = "securisation-site-gvi-web";
    private static String repertoire = "css";
    private static String path = LinksPath.protocol + LinksPath.host + "/" + LinksPath.applicationName + "/" + LinksPath.repertoire;
    private static String pathLink = LinksPath.protocol + LinksPath.host + "/" + LinksPath.applicationName;

    public LinksPath() throws UnknownHostException {
        //host = ;
    }

    public static String getTechnicienNonConnecte() {
        String error = LinksPath.pathLink + "/errorPages/pageTechnicienNonConnect.jsf";
        return error;
    }

    public static List<String> getIps() {
        List<String> ips = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {  // carte reseau trouvee
                NetworkInterface interfaceN = (NetworkInterface) interfaces.nextElement();
                Enumeration<InetAddress> ienum = interfaceN.getInetAddresses();
                while (ienum.hasMoreElements()) {  // retourne l adresse IPv4 et IPv6
                    InetAddress ia = ienum.nextElement();
                    String adress = ia.getHostAddress().toString();
                    if (adress.length() < 16) {          //On s'assure ainsi que l'adresse IP est bien IPv4
                        if (adress.startsWith("127")) {  //Ce n'est pas l'adresse IP Local' 
                            System.out.println(ia.getHostAddress());
                        } else if (adress.indexOf(":") > 0) {
                            System.out.println(ia.getHostAddress()); // les ":" indique que c'est une IPv6"
                        }
                    }
                    ips.add(adress);
                }
            }
        } catch (Exception e) {
            System.out.println("pas de carte reseau");
            e.printStackTrace();
        }

        return ips;
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

    public static String getPathLinkStatic() {
        return pathLink;
    }
}
