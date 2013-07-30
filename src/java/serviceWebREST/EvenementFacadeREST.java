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
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Evenement;

/**
 *
 * @author damien
 */
//@javax.ejb.Stateless
@Path("evenement")
public class EvenementFacadeREST {

    private EvenementService evenementSrv = MetierFactory.getEvenementService();

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Evenement entity) {
        try {
            this.evenementSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Evenement entity) {
        try {
            this.evenementSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Evenement find(@PathParam("id") Long id) {
        return this.evenementSrv.getById(id);
    }
    @GET
    @Produces({"application/xml", "application/json"})
    public List<Evenement> findAll() {
        List<Evenement> evenements = null;
        try {
           evenements =this.evenementSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evenements;
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/json", "application/json"})
    public List<Evenement> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        List<Evenement> evenements = null;
        try {
          evenements=  this.evenementSrv.getByMostRecent(from, nb);
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evenements;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.evenementSrv.count());
    }
}
