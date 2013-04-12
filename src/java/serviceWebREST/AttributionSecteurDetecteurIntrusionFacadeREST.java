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
import metier.AttributionSecteurDetecteurIntrusionService;
import metier.DetecteurIntrusionService;
import metier.MetierFactory;
import metier.SecteurService;
import metier.entitys.AttributionSecteurDetecteurIntrusion;

/**
 *
 * @author damien
 */
@Path("attributionsecteurdetecteurintrusion")
public class AttributionSecteurDetecteurIntrusionFacadeREST {

    private DetecteurIntrusionService cameraSrv = MetierFactory.getDetecteurIntrusionService();
    private SecteurService secteurSrv = MetierFactory.getSecteurService();
    private AttributionSecteurDetecteurIntrusionService attributionSecteurDetecteurIntrusionSrv = MetierFactory.getAttributionSecteurDetecteurIntrusionService();

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(AttributionSecteurDetecteurIntrusion entity) {
        try {
            this.attributionSecteurDetecteurIntrusionSrv.add(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurDetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    public void edit(AttributionSecteurDetecteurIntrusion entity) {
        try {
            this.attributionSecteurDetecteurIntrusionSrv.update(entity);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurDetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @PUT
    @Path("attribuer/{secteur}/{detecteur}")
    public void attribuer(@PathParam("secteur") Long idSecteur, @PathParam("detecteur") Long idDetecteur) {
        this.attributionSecteurDetecteurIntrusionSrv.attribuerDetecteurIntrusion(this.secteurSrv.getById(idSecteur), this.cameraSrv.getById(idDetecteur));
    }
    @PUT
    @Path("desattribuer/{secteur}/{detecteur}")
    public void desattribuer(@PathParam("secteur") Long idSecteur, @PathParam("detecteur") Long idDetecteur) {
        this.attributionSecteurDetecteurIntrusionSrv.desattribuerDetecteurIntrusion(this.secteurSrv.getById(idSecteur), this.cameraSrv.getById(idDetecteur));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        AttributionSecteurDetecteurIntrusion asdi = new AttributionSecteurDetecteurIntrusion();
        asdi.setId(id);
        try {
            this.attributionSecteurDetecteurIntrusionSrv.remove(asdi);
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurDetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("{idDetecteur}")
    @Produces({"application/xml", "application/json"})
    public AttributionSecteurDetecteurIntrusion find(@PathParam("idDetecteur") Long id) {
        return this.attributionSecteurDetecteurIntrusionSrv.getBySecteur(this.secteurSrv.getById(id));
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<AttributionSecteurDetecteurIntrusion> findAll() {
        List<AttributionSecteurDetecteurIntrusion> detecteurIntrusions = null;
        try {
            detecteurIntrusions = this.attributionSecteurDetecteurIntrusionSrv.getAll();
        } catch (Exception ex) {
            Logger.getLogger(AttributionSecteurDetecteurIntrusionFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detecteurIntrusions;
    }

//    @GET
//    @Path("{from}/{to}")
//    @Produces({"application/xml", "application/json"})
//    public List<AttributionSecteurDetecteurIntrusion> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(this.attributionSecteurDetecteurIntrusionSrv.count());
    }
}
