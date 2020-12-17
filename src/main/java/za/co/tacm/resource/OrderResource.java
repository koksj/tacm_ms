package za.co.tacm.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.model.Order;
import za.co.tacm.model.Product;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class OrderResource {

    private static final Logger log = LoggerFactory.getLogger(FarmerResource.class);

    public OrderResource() {
    }

    @POST
    @Path("/v1/order")    
    @Operation(summary = "Gets users", description = "Lists all available users")
    @Parameter( description = "The host for whom to retrieve the JVM system properties for.",
    required = true,
    example = "foo",
    schema = @Schema(type = SchemaType.STRING))
    @APIResponses(value = @APIResponse(responseCode = "200", description = "Success",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Product.class))))  
    public Response order(Order order) {

        return Response.ok().build();
    }

    @GET
    @Path("/v1/order/{order_id}")
    public Response getOrder(@PathParam("order_id}") String order_id) {

        return Response.ok().build();
    }

    @GET
    @Path("/v1/orders/{order_id}")
    public Response getOrders(@PathParam("order_id}") String order_id) {

        return Response.ok().build();
    }

    @DELETE
    @Path("/v1/order/{order_id}")
    public Response deleteOrder(@PathParam("order_id}") String order_id) {

        return Response.ok().build();
    }
}
