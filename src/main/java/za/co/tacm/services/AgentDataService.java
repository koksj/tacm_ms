package za.co.tacm.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.AgentEntity;
import za.co.tacm.entity.FarmerEntity;
import za.co.tacm.mapper.AgentMapper;
import za.co.tacm.model.Agent;

@ApplicationScoped
public class AgentDataService {

    private static final Logger log = LoggerFactory.getLogger(FarmerDataService.class);

    @Inject
    EntityManager em;

    @Inject
    AgentMapper agentMapper;

    public AgentDataService() {
    }

    /**
     * Create or Merge an agent in the DB
     * 
     * @param agent
     */
    @Transactional
    public void persistAgent(String farmer_id, AgentEntity agentEntity) {

        FarmerEntity farmerEntity = new FarmerEntity();

        try {
            // Get the famer details
            farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class)
                    .setParameter("id", farmer_id).getSingleResult();

        } catch (Exception e) {
            log.error("Famer :" + farmer_id + " not found.");
        }

        AgentEntity agent = new AgentEntity();
        try {
            // Get the product details
            agent = em.createNamedQuery("Agent.findAgentByAgentId", AgentEntity.class)
                    .setParameter("aid", agentEntity.getAid()).getSingleResult();

        } catch (Exception e) {
            log.error("Agent: " + agentEntity.getAid() + " not found.");
        }

        if (farmerEntity != null && agent != null) {
            log.info("Agent exists: " + agentEntity.getAid());
            agentEntity.setAgent_pk(agent.getAgent_pk());
            agentEntity.setFarmer(farmerEntity);
            em.merge(agentEntity);
            return;
        }
    }

    /**
     * 
     * @param aid
     * @return
     */

    public Agent getAgent(String aid) {

        AgentEntity agentEntity = em.createNamedQuery("Agent.findAgentByAgentId", AgentEntity.class)
                .setParameter("aid", aid).getSingleResult();

        if (agentEntity == null) {
            log.info("No data for agent aid: " + aid);
            agentEntity = new AgentEntity();
            agentEntity.setAid(aid);
            ;
        } else {
            log.info("Agent aid code fetched: " + agentEntity.getAid());
        }
        Agent agent = agentMapper.mapToAgent(agentEntity);

        return agent;
    }

    public List<Agent> getAgents(String id) {

        FarmerEntity farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class)
                .setParameter("id", id).getSingleResult();

        return agentMapper.mapToAgentList(farmerEntity.getAgents());
    }

    /**
     * Delete an agent by PK
     * 
     * @param aid
     * 
     */
    @Transactional
    public void deleteAgent(String aid) {

        AgentEntity agent = new AgentEntity();
        
        try {
            // Get the product details
            agent = em.createNamedQuery("Agent.findAgentByAgentId", AgentEntity.class).setParameter("aid", aid).getSingleResult();

            if (agent != null) {
                FarmerEntity farmer = em.find(FarmerEntity.class, agent.getFarmer().getFarmer_pk());
                farmer.removeAgent(agent);
                em.remove(agent);
                log.error("Agent: " + agent.getAid() + " removed");
                
            }

            

        } catch (Exception e) {
            log.error("Agent: " + agent.getAid() + " not found.");
        }
    }
}