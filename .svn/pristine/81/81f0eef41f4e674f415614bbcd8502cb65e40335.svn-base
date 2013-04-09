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
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Evenement;
import metier.entitys.Intrusion;

/**
 *
 * @author damien
 */
@Path("intrusion")
public class IntrusionFacadeREST {
    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Intrusion entity) {
        try {
            this.evenementSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(IntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Intrusion entity) {
        try {
            this.evenementSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(IntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Evenement e = new Evenement();
        e.setId(id);
        try {
            this.evenementSrv.remove(e);
        } catch (Exception ex) {
            Logger.getLogger(IntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Intrusion find(@PathParam("id") Long id) {
        return (Intrusion) this.evenementSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Intrusion> findAll() {
        List<Intrusion> intrusions =null;
        try {
             intrusions = this.evenementSrv.getByIntrusion();
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return intrusions;
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<Intrusion> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
         List<Intrusion> intrusions =null;
        try {
             intrusions = this.evenementSrv.getByIntrusion(from, nb);
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return intrusions;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.evenementSrv.count());
    }
}
