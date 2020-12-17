package za.co.tacm.resource;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.vertx.core.json.JsonObject;

@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class UuidResource {
    
    @GET
    @Path("/v1/uuid/")
    public Response getUUID() {

        final JsonObject jsonObject = new JsonObject();
        jsonObject.put("uuid", UUID.randomUUID().toString());

        return Response.ok(jsonObject.toString()).build();
    }
}
