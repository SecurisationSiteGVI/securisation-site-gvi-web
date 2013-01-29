package client.camera;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author marvin
 */
@ManagedBean
@RequestScoped
public class CameraHEDEN {

    private String ipCameraHeden="http://172.16.79.214/videostream.cgi?user=admin&pwd=marvin&resolution=32";
    public CameraHEDEN() {
    }

    /**
     * @return the test
     */
    public String getCameraHEDEN() {
        return ipCameraHeden;
    }

    /**
     * @param test the test to set
     */
    public void setCameraHEDEN(String ipCameraHeden) {
        this.ipCameraHeden = ipCameraHeden;
    }
}
