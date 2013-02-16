/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.List;
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
@Path("utilisateur")
public class UtilisateurFacadeREST {

    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Utilisateur entity) {
        System.out.println("create");
        this.utilisateurSrv.add(entity);
    }

    @POST
    @Path("verificationConnexion")
    @Consumes({"application/xml", "application/json"})
    public Technicien verificationConnexion(Technicien entity) {
        Technicien t = this.utilisateurSrv.verifificationConnexion(entity.getLogin(), entity.getPassword());
        return t;
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Utilisateur entity) {
        this.utilisateurSrv.update(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Utilisateur u = this.utilisateurSrv.getById(id);
        System.out.println(id + " delete");
        this.utilisateurSrv.remove(u);
    }

    
    @POST
    @Path("loginIsUse")
    @Consumes({"application/xml", "application/json"})
    public String loginIsUse(Technicien technicien) {
        System.out.println("LOGIN PARAM : "+technicien.getLogin());
         return String.valueOf(this.utilisateurSrv.loginIsUtilise(technicien.getLogin()));
    }
    
    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Utilisateur find(@PathParam("id") Long id) {
        return this.utilisateurSrv.getAll().get(25);
    }

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
