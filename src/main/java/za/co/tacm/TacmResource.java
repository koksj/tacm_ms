package za.co.tacm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.json.JsonObject;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class TacmResource {

    private static final Logger log = LoggerFactory.getLogger(TacmResource.class);

    @Inject
    DataService dataService;

    public TacmResource() {

    }

    @POST
    @Path("/v1/farmer")
    public Response farmer(Farmer farmer) {

        log.info("Farmer Id" + farmer.getId());
        
        dataService.createFarmer(farmer);

        return Response.ok().build();
    }

    @GET
    @Path("/v1/farmer/{id}")
    public Response farmer(@PathParam("id") String id) {

        Farmer farmer = dataService.getFarmer(id);

        return Response.ok(farmer).build();
    }

    @GET
    @Path("/v1/farmers")
    public Response getFarmers() {

        Set<Person> farmers = new HashSet<>();
        Person person = new Person();
        person.setFirstName("Mike");
        farmers.add(person);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        log.info("Farmers end point called: " + formatter.format(date));

        return Response.ok(farmers).build();
    }

    @GET
    @Path("/v1/registration/{id}")
    public Response registrationCompleted(@PathParam("id") String id) {

        Registration registration = dataService.getRegistration(id);

        return Response.ok(registration).build();
    }

    @POST
    @Path("/v1/registration")
    public Response registration(Registration registration) {

        dataService.createRegistration(registration);

        return Response.ok().build();
    }

    /**
     * Create a new agent
     * @param agent
     * @return
     */
    @POST
    @Path("/v1/agent")
    public Response agent(Agent agent) {
        
        dataService.createAgent(agent);

        return Response.ok().build();
    }

    /**
     * 
     * @param aid Primary key for agant
     * @return
     */
    @GET
    @Path("/v1/agent/{aid}")
    public Response agent(@PathParam("aid") String aid) {

        Agent agent = dataService.getAgent(aid);

        return Response.ok(agent).build();
    }

    @DELETE
    @Path("/v1/agent/{aid}")
    public Response deleteAgent(@PathParam("aid") String aid) {

        dataService.deleteAgent(aid);

        return Response.ok().build();
    }

     /**
     * Returns the agaents registered by a farmer
     * @param id PK for farmer
     * @return
     */
    @GET
    @Path("/v1/agents/{id}")
    public Response getAgents(@PathParam("id") String id) {

        List<Agent> agents = dataService.getAgents(id);

        return Response.ok(agents).build();
    }


    @GET
    @Path("/v1/uuid/")   
    public Response getUUID() {
       
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("uuid", UUID.randomUUID().toString());        

        return Response.ok(jsonObject.toString()).build();
    }


}