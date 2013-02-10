/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.List;
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
import metier.MetierFactory;
import metier.UtilisateurService;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@Path("utilisateur")
public class UtilisateurFacadeREST {
    private UtilisateurService utilisateurSrv =MetierFactory.getUtilisateurService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Utilisateur entity) {
        this.utilisateurSrv.add(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Utilisateur entity) {
        this.utilisateurSrv.update(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Utilisateur u = new Utilisateur();
        u.setId(id);
        this.utilisateurSrv.remove(u);
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public Utilisateur find(@PathParam("id") Long id) {
//        return super.find(id);
//    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> findAll() {
        return this.utilisateurSrv.getAll();
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<Utilisateur> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        return this.utilisateurSrv.getAllByRange(from, nb);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.utilisateurSrv.count());
    }
 
}
