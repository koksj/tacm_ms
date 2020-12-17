package za.co.tacm.resource;

import javax.annotation.security.RolesAllowed;
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

import za.co.tacm.entity.RegistrationEntity;
import za.co.tacm.mapper.RegistrationMapper;
import za.co.tacm.model.Registration;
import za.co.tacm.services.RegistrationDataService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class RegistrationResource {

    private static final Logger log = LoggerFactory.getLogger(RegistrationResource.class);

    @Inject
    RegistrationDataService dataService;


    @Inject
    RegistrationMapper registrationMapper;
    
    public RegistrationResource() {

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

        RegistrationEntity registrationEntity = registrationMapper.mapToRegistrationEntity(registration);
        dataService.persistRegistration(registrationEntity);
     
        return Response.ok().build();
    }

   
    
}
