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
import metier.entitys.Acces;

/**
 *
 * @author damien
 */
@Path("metier.entitys.acces")
public class AccesFacadeREST {

    private EvenementService evenementSrv = MetierFactory.getEvenementService();

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Acces entity) {
        try {
            this.evenementSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(AccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Acces entity) {
        try {
            this.evenementSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(AccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Acces ac = new Acces();
        ac.setId(id);
        try {
            this.evenementSrv.remove(ac);
        } catch (Exception ex) {
            Logger.getLogger(AccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Acces find(@PathParam("id") Long id) {
//        this.evenementSrv.getById(id);
        return null;
    }
    
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Acces> findAll() {
        return this.evenementSrv.getByAcces();
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<Acces> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        return this.evenementSrv.getByAcces(from, nb);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.evenementSrv.count());
    }
}
