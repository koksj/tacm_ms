package za.co.tacm.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.FarmerEntity;
import za.co.tacm.mapper.FarmerMapper;
import za.co.tacm.model.Farmer;

@ApplicationScoped
public class FarmerDataService {

    private static final Logger log = LoggerFactory.getLogger(FarmerDataService.class);

    @Inject
    EntityManager em;

    @Inject
    FarmerMapper farmerMapper;

    public FarmerDataService() {

    }

    /**
     * Creates a farmer if he does not exist. If he exists upadte the farmer.
     * 
     * @param farmer
     */
    @Transactional
    public void persistFarmer(FarmerEntity farmer) {

        // Merge if farmer exists
        FarmerEntity farmerEntity = new FarmerEntity();
        try {
            farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class)
                    .setParameter("id", farmer.getId()).getSingleResult();
            if (farmerEntity != null) {
                log.info("Merged farmer: " + farmer.getId());
                farmer.setFarmer_pk(farmerEntity.getFarmer_pk());
                em.merge(farmer);
                return;
            }
        } catch (NoResultException e) {
            log.info(" Famer id: " + farmer.getId() + " do not exist.");
        }

        // Create if the Famer does not exist
        try {
            em.persist(farmer);
            log.info("Persisted farmer: " + farmer.getId());
        } catch (Exception e) {
            log.error("Could not persist farmer id: " + farmer.getId(), e);
        }
    }

    public Farmer getFarmer(String id) {

        FarmerEntity farmerEntity = em.createNamedQuery("Farmer.findFarmerById", FarmerEntity.class)
                .setParameter("id", id).getSingleResult();

        if (farmerEntity == null) {
            log.info("No data for farmer id: " + id);
            farmerEntity = new FarmerEntity();
            farmerEntity.setId(id);
        } else {
            log.info("Famer id fetched: " + farmerEntity.getId());
        }
        Farmer farmer = farmerMapper.mapToFarmer(farmerEntity);

        return farmer;
    }
    
}
