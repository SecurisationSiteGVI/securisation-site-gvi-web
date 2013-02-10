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
import metier.entitys.Administrateur;
import metier.entitys.Utilisateur;

/**
 *
 * @author damien
 */
//@javax.ejb.Stateless
@Path("administrateur")
public class AdministrateurFacadeREST  {

    private UtilisateurService utilisateurSrv = MetierFactory.getUtilisateurService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Administrateur entity) {
        this.utilisateurSrv.add(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Administrateur entity) {
        this.utilisateurSrv.update(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Administrateur a =new Administrateur();
        a.setId(id);
        this.utilisateurSrv.remove(a);
    
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public Administrateur find(@PathParam("id") Long id) {
//
//    }
//
//    @GET
//    @Override
//    @Produces({"application/xml", "application/json"})
//    public List<Administrateur> findAll() {
//
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Administrateur> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces("text/plain")
//    public String countREST() {
//        return String.valueOf(super.count());
//    }   
}
