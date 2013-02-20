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
import metier.EvenementService;
import metier.MetierFactory;
import metier.entitys.Photo;

/**
 *
 * @author damien
 */
@Path("photo")
public class PhotoFacadeREST {

    private EvenementService evenementSrv = MetierFactory.getEvenementService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Photo entity) {
        try {
            this.evenementSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(PhotoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Photo entity) {
        try {
            this.evenementSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(PhotoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Photo p = new Photo();
        p.setId(id);
        try {
            this.evenementSrv.remove(p);
        } catch (Exception ex) {
            Logger.getLogger(PhotoFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Photo find(@PathParam("id") Long id) {
        return (Photo) this.evenementSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Photo> findAll() {
        List<Photo> photos =null;
        photos = this.evenementSrv.getByPhoto();
        return photos;
    }

    @GET
    @Path("{from}/{nb}")
    @Produces({"application/xml", "application/json"})
    public List<Photo> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
        return this.evenementSrv.getByPhoto(from, nb);
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.evenementSrv.count());
    }
}
