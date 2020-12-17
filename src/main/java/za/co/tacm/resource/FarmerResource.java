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

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.security.SecuritySchemes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.FarmerEntity;
import za.co.tacm.mapper.FarmerMapper;
import za.co.tacm.model.Farmer;
import za.co.tacm.services.FarmerDataService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class FarmerResource {

    private static final Logger log = LoggerFactory.getLogger(FarmerResource.class);

    @Inject
    FarmerDataService dataService;

    public FarmerResource() {

    }

    @Inject
    FarmerMapper farmerMapper;

    @POST
    @Path("/v1/farmer")
    public Response farmer(final Farmer farmer) {

        final FarmerEntity farmerEntity = farmerMapper.mapToFarmerEntity(farmer);
        dataService.persistFarmer(farmerEntity);

        return Response.ok().build();
    }

    @GET
    @Path("/v1/farmer/{id}")
    public Response getfarmer(@PathParam("id") final String id) {

        return Response.ok(dataService.getFarmer(id)).build();
    }   

}