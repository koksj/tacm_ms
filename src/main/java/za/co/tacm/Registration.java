package za.co.tacm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Registration {

    @Id    
    private String id;
    private boolean registrationCompleted;

    public Registration() {
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
