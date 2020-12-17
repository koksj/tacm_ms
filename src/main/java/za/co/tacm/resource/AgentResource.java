package za.co.tacm.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import za.co.tacm.mapper.AgentMapper;
import za.co.tacm.model.Agent;
import za.co.tacm.services.AgentDataService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/tacm")
public class AgentResource {

    @Inject
    AgentDataService dataService;

    @Inject
    AgentMapper agentMapper;

    public AgentResource() {
    }

     /**
     * Create a new agent
     * @param agent
     * @return
     */
    @POST
    @Path("/v1/agent")
    public Response agent(Agent agent) {
        
        dataService.persistAgent(agent.getFarmer_id(),agentMapper.mapToAgentEntity(agent));

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
     * 
     * @param id PK for farmer
     * @return
     */
    @GET
    @Path("/v1/agents/{id}")
    public Response getAgents(@PathParam("id") String id) {

        List<Agent> agents = dataService.getAgents(id);

        return Response.ok(agents).build();
    }

}
