package dk.statsbiblioteket.sboi;

import dk.statsbiblioteket.newspaper.processmonitor.datasources.Batch;
import dk.statsbiblioteket.newspaper.processmonitor.datasources.EventID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import sboi.SBOILibrary;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;


@Component
@Scope(value = "request")
@Path("/")
public class SBOIService {

    @Autowired
    private SBOILibrary lib;

    public SBOIService() {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Batch> getBatches(@QueryParam("pastEvent")List<String> successfulPreEvents, @QueryParam("futureEvent")List<String> minusSuccessfulEvent){
        return lib.getBatches(successfulPreEvents, minusSuccessfulEvent);
    }

    @GET
    @Path("/{batchID}")
    @Produces(MediaType.APPLICATION_JSON)
    public Batch getNewestBatch(@PathParam("batchID")Long batchID){
        return lib.getBatch(batchID,null);
    }

    @GET
    @Path("/{batchID}/{runNr}")
    @Produces(MediaType.APPLICATION_JSON)
    public Batch getSpecificBatch(@PathParam("batchID")Long batchID,@PathParam("runNr")Integer runNr){
        return lib.getBatch(batchID,runNr);
    }



    @POST
    @Path("/{batchID}/{runNr}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void registerEvent(@PathParam("batchID")Long batchID,@PathParam("runNr")Integer runNr,
                              @FormParam("eventID")EventID eventID,
                              @FormParam("agent")String agent,
                              @FormParam("timestamp")Date timestamp,
                              @FormParam("details")String details,
                              @FormParam("success")boolean success){
        lib.registerEvent(batchID, runNr, eventID, agent, timestamp, details, success);
    }


}
