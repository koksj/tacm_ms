package za.co.tacm.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import za.co.tacm.entity.RegistrationEntity;
import za.co.tacm.mapper.RegistrationMapper;
import za.co.tacm.model.Registration;

@ApplicationScoped
public class RegistrationDataService {

    private static final Logger log = LoggerFactory.getLogger(RegistrationDataService.class);

    @Inject
    EntityManager em;

    @Inject
    RegistrationMapper registrationMapper;

    public RegistrationDataService() {
    }

    public Registration getRegistration(String id) {

        RegistrationEntity registrationEntity = em.find(RegistrationEntity.class, id);

        if (registrationEntity == null) {
            log.info("No data for registration id: " + id);
            registrationEntity = new RegistrationEntity();
            registrationEntity.setId(id);
            registrationEntity.setRegistrationCompleted(false);
        } else {
            log.info("Registration id fetched: " + registrationEntity.getId() + " " + registrationEntity.isRegistrationCompleted());
        }

        return registrationMapper.mapToRegistration(registrationEntity);
    }

    @Transactional
    public void persistRegistration(RegistrationEntity registration) {

        RegistrationEntity registrationTest = em.find(RegistrationEntity.class, registration.getId());
        if (registrationTest != null) {
            em.merge(registration);
            log.info("Merge registration: " + registration.getId());
        } else {
            em.persist(registration);
            log.info("Persist registration: " + registration.getId());
        }

    }
}