package za.co.tacm.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import za.co.tacm.entity.AgentEntity;
import za.co.tacm.model.Agent;

@Mapper(componentModel = "cdi")
public interface AgentMapper {

    @Mappings({
        @Mapping(target = "farmer_id", source = "agentEntity.farmer.id" )
    })
    Agent mapToAgent(AgentEntity agentEntity);

    AgentEntity mapToAgentEntity(Agent agent);

    List<Agent> mapToAgentList(final List<AgentEntity> agents);    
}
