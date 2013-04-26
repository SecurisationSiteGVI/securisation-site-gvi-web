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
import metier.MetierFactory;
import metier.SecteurService;
import metier.entitys.Secteur;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@Path("secteur")
public class SecteurFacadeREST  {

    private SecteurService secteurSrv =MetierFactory.getSecteurService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Secteur entity) {
        try {
            this.secteurSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(SecteurFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Secteur entity) {
        try {
            this.secteurSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(SecteurFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Secteur u = this.secteurSrv.getById(id);
        try {
            this.secteurSrv.remove(u);
        } catch (Exception ex) {
            Logger.getLogger(SecteurFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Secteur find(@PathParam("id") Long id) {
        return this.secteurSrv.getById(id);
    }

    @GET
    @Produces({"application/json", "application/json"})
    public List<Secteur> findAll() {
        List<Secteur> secteurs =null;
        try {
            secteurs = this.secteurSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(SecteurFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return secteurs;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Secteur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return this.secteurSrv.getAll(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.secteurSrv.count());
    }
}
