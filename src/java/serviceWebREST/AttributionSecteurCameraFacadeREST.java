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
import metier.AttributionSecteurCameraService;
import metier.MetierFactory;
import metier.entitys.AttributionSecteurCamera;

/**
 *
 * @author damien
 */
//@javax.ejb.Stateless
@Path("attributionsecteurcamera")
public class AttributionSecteurCameraFacadeREST {
    
    private AttributionSecteurCameraService attributionSecteurCameraSrv = MetierFactory.getAttributionSecteurCameraService();
    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AttributionSecteurCamera entity) {
        try {
            this.attributionSecteurCameraSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(AttributionSecteurCamera entity) {
        try {
            this.attributionSecteurCameraSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        AttributionSecteurCamera a = new AttributionSecteurCamera();
        a.setId(id);
        try {
            this.attributionSecteurCameraSrv.remove(a);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public AttributionSecteurCamera find(@PathParam("id") Long id) {
//        this.attributionSecteurCameraSr
//    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AttributionSecteurCamera> findAll() {
        List<AttributionSecteurCamera> asc =null;
        try {
            asc =  this.attributionSecteurCameraSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurCameraFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }return asc;
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<AttributionSecteurCamera> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.attributionSecteurCameraSrv.count());
    }   
}
