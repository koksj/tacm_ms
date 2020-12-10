package za.co.tacm;

import java.util.Collection;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class DataService {

    private static final Logger log = LoggerFactory.getLogger(DataService.class);

    @Inject
    EntityManager em;

    public DataService() {

    }

    @Transactional
    public void createFarmer(Farmer farmer) {

        Farmer farmerTest = em.find(Farmer.class, farmer.getId());
        if (farmerTest != null) {
            em.merge(farmer);
            log.info("Merge farmer");
        } else {
            em.persist(farmer);
            log.info("Persist farmer");
        }

    }

    public Farmer getFarmer(String id) {

        Farmer farmer = em.find(Farmer.class, id);

        if (farmer == null) {
            log.info("No data for farmer id: " + id);
            farmer = new Farmer();
            farmer.setId(id);
        } else {
            log.info("Famer id fetched: " + farmer.getId());
        }

        return farmer;
    }

    public Registration getRegistration(String id) {

        Registration registration = em.find(Registration.class, id);

        if (registration == null) {
            log.info("No data for registration id: " + id);
            registration = new Registration();
            registration.setId(id);
            registration.setRegistrationCompleted(false);
        } else {
            log.info("Registration id fetched: " + registration.getId() + " " + registration.isRegistrationCompleted());
        }

        return registration;
    }

    @Transactional
    public void createRegistration(Registration registration) {

        Registration registrationTest = em.find(Registration.class, registration.getId());
        if (registrationTest != null) {
            em.merge(registration);
            log.info("Merge registration: " + registration.getId());
        } else {
            em.persist(registration);
            log.info("Persist registration: " + registration.getId());
        }

    }

    /**
     * Create or Merge an agent in the DB
     * 
     * @param agent
     */

    @Transactional
    public void createAgent(Agent agent) {

        Agent tmp = em.find(Agent.class, agent.getAid());
        if (tmp == null) {
            em.persist(agent);
        } else {
            em.merge(agent);
        }

    }

    /**
     * 
     * @param aid PK for Agent
     * @return
     */
    public Agent getAgent(String aid) {

        Agent agent = em.find(Agent.class, aid);

        if (agent == null) {
            log.info("No data for id and aid: " + aid);
            agent = new Agent();
            agent.setId(aid);
        } else {
            log.info("Agent id fetched: " + agent.getId());
        }

        return agent;
    }

    public List<Agent> getAgents(String id) {

        List<Agent> agents = em.createNamedQuery("Agent.findAgentsByFamer", Agent.class).setParameter("id", id)
                .getResultList();

        return agents;
    }

    /**
     * Delete an agent by PK
     * 
     * @param aid
     * 
     */
    @Transactional
    public void deleteAgent(String aid) {

        Agent agent = em.find(Agent.class, aid);

        if (agent == null) {
            log.error("Cannot delete agent id: " + aid + " No such entity found.");
        } else {
            log.info("Deleting Agent id: " + aid);
            em.remove(agent);
        }

    }

}
