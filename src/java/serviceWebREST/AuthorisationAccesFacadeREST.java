/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.Date;
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
import metier.entitys.Utilisateur;

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

    @POST
    @Path("2/{oh}/{om}/{fh}/{fm}/{idutilisateur}")
    @Consumes({"application/xml", "application/json"})
    public void create2(@PathParam("oh") int oh,@PathParam("fh") int fh,@PathParam("fm") int fm,@PathParam("om") int om,@PathParam("idutilisateur")Long idUtilisateur) {
        AuthorisationAcces aa = new AuthorisationAcces();
        Date dateOuverture = new Date();
        dateOuverture.setHours(oh);
        dateOuverture.setMinutes(om);
        Date dateFermeture = new Date();
        dateFermeture.setHours(fh);
        dateFermeture.setMinutes(fm);
        aa.setHeureFermeture(dateFermeture);
        aa.setHeureOuverture(dateOuverture);
        aa.setUtilisateur(MetierFactory.getUtilisateurService().getById(idUtilisateur));
        try {
            this.authorisationAccesSrv.add(aa);
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @POST
    @Path("atacher/{idUtilisateur}/{idSecteur}")
    @Consumes({"application/xml", "application/json"})
    public void atacher(@PathParam("idUtilisateur") Long idUtilisateur, @PathParam("idSecteur") Long idSecteur) {
        try {
            this.authorisationAccesSrv.atacherSecteurFromUtilisateur(MetierFactory.getSecteurService().getById(idSecteur), MetierFactory.getUtilisateurService().getById(idUtilisateur));
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @POST
    @Path("detacher/{idUtilisateur}/{idSecteur}")
    @Consumes({"application/xml", "application/json"})
    public void detacher(@PathParam("idUtilisateur") Long idUtilisateur, @PathParam("idSecteur") Long idSecteur) {
        try {
            this.authorisationAccesSrv.detacherSecteurFromUtilisateur(MetierFactory.getSecteurService().getById(idSecteur), MetierFactory.getUtilisateurService().getById(idUtilisateur));
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
    
    @PUT
    @Path("3/{oh}/{om}/{fh}/{fm}/{idutilisateur}")
    @Consumes({"application/xml", "application/json"})
    public void edit2(@PathParam("oh") int oh,@PathParam("fh") int fh,@PathParam("fm") int fm,@PathParam("om") int om,@PathParam("idutilisateur")Long idUtilisateur) throws Exception {
        Utilisateur u = MetierFactory.getUtilisateurService().getById(idUtilisateur);
        AuthorisationAcces aa = this.authorisationAccesSrv.getByUtilisateur(u);
        aa.getHeureOuverture().setHours(oh);
        aa.getHeureOuverture().setMinutes(om);
        aa.getHeureFermeture().setHours(fh);
        aa.getHeureFermeture().setMinutes(fm);
        try {
            this.authorisationAccesSrv.update(aa);
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

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public AuthorisationAcces find(@PathParam("id") Long id) {
        return this.authorisationAccesSrv.getById(id);
    }

    @GET
    @Path("byUtilisateur/{id}")
    @Produces({"application/xml", "application/json"})
    public AuthorisationAcces findByUtilisateur(@PathParam("id") Long id) {
        AuthorisationAcces byUtilisateur = null;
        try {
            byUtilisateur = this.authorisationAccesSrv.getByUtilisateur(MetierFactory.getUtilisateurService().getById(id));
        } catch (Exception ex) {
            Logger.getLogger(AuthorisationAccesFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return byUtilisateur;
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AuthorisationAcces> findAll() {
        List<AuthorisationAcces> aas = null;
        try {
            aas = this.authorisationAccesSrv.getAll();
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
