package za.co.tacm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class RegistrationEntity {

    @Id
    @Column(name = "registration_id")
    private String id;

    @Column(name = "registration_completed")
    private boolean registrationCompleted;

    public RegistrationEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isRegistrationCompleted() {
        return registrationCompleted;
    }

    public void setRegistrationCompleted(boolean registrationCompleted) {
        this.registrationCompleted = registrationCompleted;
    }

    @Override
    public String toString() {
        return "Registration [id=" + id + ", registrationCompleted=" + registrationCompleted + "]";
    }

}
