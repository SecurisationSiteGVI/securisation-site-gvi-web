/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import metier.CameraService;
import metier.MetierFactory;
import metier.entitys.Camera;

/**
 *
 * @author damien
 */

@Path("camera")
public class CameraFacadeREST  {
    private CameraService cameraSrv = MetierFactory.getCameraService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Camera entity) {
        try {
            this.cameraSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(CameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Camera entity) {
        try {
            this.cameraSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(CameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Camera c = new Camera();
        c.setId(id);
        try {
            this.cameraSrv.remove(c);
        } catch (Exception ex) {
            Logger.getLogger(CameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Camera find(@PathParam("id") Long id) {
        return this.cameraSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Camera> findAll() {
        List<Camera> cameras =null;
        try {
            cameras = this.cameraSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(CameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return cameras;
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Camera> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return this.cameraSrv.;
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.cameraSrv.count());
    }

}
