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
import metier.AttributionUtilisateurBadgeService;
import metier.MetierFactory;
import metier.entitys.AttributionUtilisateurBadge;

/**
 *
 * @author damien
 */

@Path("attributionutilisateurbadge")
public class AttributionUtilisateurBadgeFacadeREST  {
    private AttributionUtilisateurBadgeService attributionUtilisateurBadgeSrv = MetierFactory.getAttributionUtilisateurBadgeService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AttributionUtilisateurBadge entity) {
        try {
            this.attributionUtilisateurBadgeSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionUtilisateurBadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(AttributionUtilisateurBadge entity) {
        try {
            this.attributionUtilisateurBadgeSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionUtilisateurBadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        AttributionUtilisateurBadge aub = new AttributionUtilisateurBadge();
        aub.setId(id);
        try {
            this.attributionUtilisateurBadgeSrv.remove(aub);
        } catch (Exception ex) {
            Logger.getLogger(AttributionUtilisateurBadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public AttributionUtilisateurBadge find(@PathParam("id") Long id) {
        return this.attributionUtilisateurBadgeSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AttributionUtilisateurBadge> findAll() {
        List<AttributionUtilisateurBadge> attributionUtilisateurBadges =null;
        try {
            attributionUtilisateurBadges = attributionUtilisateurBadgeSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionUtilisateurBadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attributionUtilisateurBadges;
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<AttributionUtilisateurBadge> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        List<AttributionUtilisateurBadge> attributionUtilisateurBadges= null;
        attributionUtilisateurBadges = attributionUtilisateurBadgeSrv.getAll(from, nb);
        return attributionUtilisateurBadges;
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.attributionUtilisateurBadgeSrv.count());
    }

 
    
}
