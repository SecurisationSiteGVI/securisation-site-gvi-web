/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serviceWebREST;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import metier.PositionService;
import metier.entitys.Position;

/**
 *
 * @author damien
 */

@Path("metier.entitys.position")
public class PositionFacadeREST {
    private PositionService positionSrv = MetierFactory.getPositionService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Position entity) {
        try {
            this.positionSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(PositionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(Position entity) {
        try {
            this.positionSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(PositionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        Position p = new Position();
        p.setId(id);
        try {
            this.positionSrv.remove(p);
        } catch (Exception ex) {
            Logger.getLogger(PositionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Position find(@PathParam("id") Long id) {
        return this.positionSrv.getById(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Position> findAll() {
        List<Position> positions =null;
        try {
            positions = this.positionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(PositionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return positions;
    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<Position> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.positionSrv.count());
    }
}
