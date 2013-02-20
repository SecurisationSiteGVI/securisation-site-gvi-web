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
import metier.entitys.Technicien;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
@Path("technicien")
public class TechnicienFacadeREST {
    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Technicien entity) {
        this.utilisateurSrv.add(entity);
        
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Technicien entity) {
        this.utilisateurSrv.update(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Utilisateur u= new Utilisateur();
        u.setId(id);
        this.utilisateurSrv.remove(u);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Technicien find(@PathParam("id") Long id) {
        return (Technicien) this.utilisateurSrv.getById(id);
    }

    @GET
    @Path("loginIsUse/{login}")
    @Produces({"application/xml", "application/json"})
    public boolean loginIsUse(@PathParam("login") String login) {
        return this.loginIsUse(login);
    }

    @GET
    @Path("{login}/{mdp}")
    @Produces({"application/xml", "application/json"})
    public Technicien verificationConnexion(@PathParam("from") String login, @PathParam("to") String mdp) {
        return this.utilisateurSrv.verifificationConnexion(login, mdp);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.utilisateurSrv.count());
    }
}
