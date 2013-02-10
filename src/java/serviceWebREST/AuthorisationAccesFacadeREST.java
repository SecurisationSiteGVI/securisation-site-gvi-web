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
import metier.AuthorisationAccesService;
import metier.MetierFactory;
import metier.entitys.AuthorisationAcces;

/**
 *
 * @author damien
 */

@Path("authorisationacces")
public class AuthorisationAccesFacadeREST {
    private AuthorisationAccesService authorisationAccesSrv = MetierFactory.getAuthorisationAccesService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AuthorisationAcces entity) {
        try {
            this.authorisationAccesSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(AuthorisationAcces entity) {
        try {
            this.authorisationAccesSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        AuthorisationAcces aa = new AuthorisationAcces();
        aa.setId(id);
        try {
            this.authorisationAccesSrv.remove(aa);
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public AuthorisationAcces find(@PathParam("id") Long id) {
//        return super.find(id);
//    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AuthorisationAcces> findAll() {
        List<AuthorisationAcces> aas = null;
        try {
            aas= this.authorisationAccesSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aas;
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<AuthorisationAcces> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return this.authorisationAccesSrv.get;
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.authorisationAccesSrv.count());
    }
}
