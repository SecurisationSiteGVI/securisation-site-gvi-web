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
import metier.NumeroPredefinisService;
import metier.entitys.NumeroPredefinis;

/**
 *
 * @author damien
 */

@Path("numeropredefinis")
public class NumeroPredefinisFacadeREST {
    private NumeroPredefinisService numeroPredefinis = MetierFactory.getNumeroPredefinisService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(NumeroPredefinis entity) {
        try {
            this.numeroPredefinis.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(NumeroPredefinisFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @POST
    @Path("add/{numero}")
    @Consumes({"application/xml", "application/json"})
    public void addNum(@PathParam("numero")String numero) {
        try {
            this.numeroPredefinis.ajouterUnNumero(numero);
        } catch (Exception ex) {
            Logger.getLogger(NumeroPredefinisFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @POST
    @Path("remove/{numero}")
    @Consumes({"application/xml", "application/json"})
    public void removeNum(@PathParam("numero")String numero) {
        try {
            this.numeroPredefinis.supprimerUnNumero(numero);
        } catch (Exception ex) {
            Logger.getLogger(NumeroPredefinisFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(NumeroPredefinis entity) {
        try {
            this.numeroPredefinis.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(NumeroPredefinisFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        try {
            NumeroPredefinis np = new NumeroPredefinis();
            np.setId(id);
            this.numeroPredefinis.remove(np);
        } catch (Exception ex) {
            Logger.getLogger(NumeroPredefinisFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    @PUT
    @Path("{id}")
    public void removePUT(@PathParam("id") Long id) {
        NumeroPredefinis b = this.numeroPredefinis.getById(id);
        try {
            this.numeroPredefinis.remove(b);
        } catch (Exception ex) {
            Logger.getLogger(BadgeFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public NumeroPredefinis find(@PathParam("id") Long id) {
        return this.numeroPredefinis.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<NumeroPredefinis> findAll() {
         List<NumeroPredefinis> numeroPredefinises =null;
        try {
             numeroPredefinises = this.numeroPredefinis.getAll();
        } catch (Exception ex) {
            Logger.getLogger(EvenementFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return numeroPredefinises;
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<NumeroPredefinis> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return this.numeroPredefinis.getAll(from, to);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.numeroPredefinis.count());
    }

}
