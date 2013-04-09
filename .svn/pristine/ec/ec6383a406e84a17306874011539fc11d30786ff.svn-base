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
import metier.BadgeService;
import metier.MetierFactory;
import metier.entitys.Badge;

/**
 *
 * @author damien
 */
@Path("badge")
public class BadgeFacadeREST {

    private BadgeService badgeSrv = MetierFactory.getBadgeService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Badge entity) {
        try {
            this.badgeSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Badge entity) {
        try {
            this.badgeSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Badge b = new Badge();
        b.setId(id);
        try {
            this.badgeSrv.add(b);
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Badge find(@PathParam("id") Long id) {
        return this.badgeSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Badge> findAll() {
        List<Badge> badges=null;
        try {
            badges= this.badgeSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return badges;
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<Badge> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        List<Badge> badges =null;
        try {
             this.badgeSrv.getAll(from, nb);
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return badges;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.badgeSrv.count());
    }

}
