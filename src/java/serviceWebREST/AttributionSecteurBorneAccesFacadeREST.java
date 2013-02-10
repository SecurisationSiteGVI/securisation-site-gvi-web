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
import metier.AttributionSecteurBorneAccesService;
import metier.MetierFactory;
import metier.entitys.AttributionSecteurBorneAcces;

/**
 *
 * @author damien
 */
@Path("attributionsecteurborneacces")
public class AttributionSecteurBorneAccesFacadeREST  {
    private AttributionSecteurBorneAccesService attributionSecteurBorneAccesSrv = MetierFactory.getAttributionSecteurBorneAccesService();

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AttributionSecteurBorneAcces entity) {
        this.attributionSecteurBorneAccesSrv.add(entity);
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(AttributionSecteurBorneAcces entity) {
        this.attributionSecteurBorneAccesSrv.update(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        AttributionSecteurBorneAcces a  =new AttributionSecteurBorneAcces();
        a.setId(id);
        this.attributionSecteurBorneAccesSrv.add(a);
    }

//    @GET
//    @Path("{id}")
//    @Produces({"application/xml", "application/json"})
//    public AttributionSecteurBorneAcces find(@PathParam("id") Long id) {
//        return super.find(id);
//    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AttributionSecteurBorneAcces> findAll() {
        return this.attributionSecteurBorneAccesSrv.getAll();
    }

//    @GET
//    @Path("{from}/{nb}")
//    @Produces({"application/xml", "application/json"})
//    public List<AttributionSecteurBorneAcces> findRange(@PathParam("from") Integer from, @PathParam("nb") Integer nb) {
//        return this.attributionSecteurBorneAccesSrv.ge;
//    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.attributionSecteurBorneAccesSrv.count());
    }
}
