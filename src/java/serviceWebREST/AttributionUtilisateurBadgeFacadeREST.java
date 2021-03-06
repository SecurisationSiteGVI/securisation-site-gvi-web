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
import metier.entitys.Badge;
import metier.entitys.Utilisateur;

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
    
    @POST
    @Path("attribuer/{idUtilisateur}/{idBadge}")
    @Produces({"application/xml", "application/json"})
    public void attribuer(@PathParam("idUtilisateur") Long idUtilisateur,@PathParam("idBadge") Long idBadge) {
        Utilisateur u = MetierFactory.getUtilisateurService().getById(idUtilisateur);
        Badge b = MetierFactory.getBadgeService().getById(idBadge);
        AttributionUtilisateurBadge aub = new AttributionUtilisateurBadge();
        aub.setBadge(b);
        aub.setUtilisateur(u);
        try {
            this.attributionUtilisateurBadgeSrv.add(aub);
        } catch (Exception ex) {
            Logger.getLogger(AttributionUtilisateurBadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    @Path("getBadgesNotAssign/{debut}/{nbResult}")
    @Produces({"application/xml", "application/json"})
    public List<Badge> getBadgesNotAssign(@PathParam("debut") Integer debut,@PathParam("nbResult") Integer nbResult) {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssign(debut, nbResult);
    }
    @GET
    @Path("getBadgesNotAssignByNumero/{numero}/{debut}/{nbResult}")
    @Produces({"application/xml", "application/json"})
    public List<Badge> getBadgesNotAssignByNumero(@PathParam("numero") String numero,@PathParam("debut") Integer debut,@PathParam("nbResult") Integer nbResult) {
        return this.attributionUtilisateurBadgeSrv.getBadgesNotAssignByNumero(numero, debut, nbResult);
    }   
    
    @GET
    @Path("getUtilisateurNotAssign/{debut}/{nbResult}")
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> getUtilisateurNotAssign(@PathParam("debut") Integer debut,@PathParam("nbResult") Integer nbResult) {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssign(debut, nbResult);
    }
    @GET
    @Path("getUtilisateurNotAssignByNom/{numero}/{debut}/{nbResult}")
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> getUtilisateurNotAssignByNom(@PathParam("numero") String nom,@PathParam("debut") Integer debut,@PathParam("nbResult") Integer nbResult) {
        return this.attributionUtilisateurBadgeSrv.getUtilisateurNotAssignByNom(nom, debut, nbResult);
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
