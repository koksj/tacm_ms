package za.co.tacm;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    @POST
    @Path("/v1/agent")
    public Response agent(Agent agent) {

        dataService.createAgent(agent);

        return Response.ok().build();
    }

    @GET
    @Path("/v1/agent/{id}")
    public Response agent(@PathParam("id") String id) {

        Agent agent = dataService.getAgent(id);

        return Response.ok(agent).build();
    }   

}