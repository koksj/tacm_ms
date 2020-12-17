package za.co.tacm.mapper;

import org.mapstruct.Mapper;

import za.co.tacm.entity.RegistrationEntity;
import za.co.tacm.model.Registration;

@Mapper(componentModel = "cdi")
public interface RegistrationMapper {

    Registration mapToRegistration(RegistrationEntity registrationEntity);
    RegistrationEntity mapToRegistrationEntity(Registration registration);
    
}
