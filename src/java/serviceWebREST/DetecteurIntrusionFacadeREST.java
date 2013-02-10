/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import metier.DetecteurIntrusionService;
import metier.MetierFactory;
import metier.entitys.DetecteurIntrusion;

/**
 *
 * @author damien
 */
@Path("detecteurintrusion")
public class DetecteurIntrusionFacadeREST  {
    private DetecteurIntrusionService detecteurIntrusionSrv = MetierFactory.getDetecteurIntrusionService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(DetecteurIntrusion entity) {
        try {
            this.detecteurIntrusionSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(DetecteurIntrusion entity) {
        try {
            this.detecteurIntrusionSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        DetecteurIntrusion detecteurIntrusion = new DetecteurIntrusion();
        detecteurIntrusion.setId(id);
        try {
            this.detecteurIntrusionSrv.remove(detecteurIntrusion);
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//
//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public DetecteurIntrusion find(@PathParam("id") Long id) {
//        return this.detecteurIntrusionSrv.
//    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<DetecteurIntrusion> findAll() {
        List<DetecteurIntrusion> detecteurIntrusions =null;
        try {
            detecteurIntrusions= this.detecteurIntrusionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(DetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return detecteurIntrusions;
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<DetecteurIntrusion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return this.detecteurIntrusionSrv.get;
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.detecteurIntrusionSrv.count());
    }

}
