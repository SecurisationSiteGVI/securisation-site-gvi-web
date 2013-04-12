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
import metier.BorneAccesService;
import metier.MetierFactory;
import metier.entitys.BorneAcces;

/**
 *
 * @author damien
 */

@Path("borneacces")
public class BorneAccesFacadeREST{
    private BorneAccesService borneAccesSrv = MetierFactory.getBorneAccesService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(BorneAcces entity) {
        try {
            this.borneAccesSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(BorneAcces entity) {
        try {
            this.borneAccesSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        BorneAcces acces = new BorneAcces();
        acces.setId(id);
        try {
            this.borneAccesSrv.remove(acces);
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public BorneAcces find(@PathParam("id") Long id) {
        return this.borneAccesSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<BorneAcces> findAll() {
        List<BorneAcces> acceses = null;
        try {
            acceses =  this.borneAccesSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(BorneAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acceses;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<BorneAcces> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return this.borneAccesSrv.getAll(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.borneAccesSrv.count());
    }

}
