package za.co.tacm;

import java.util.HashMap;
import java.util.Map;

public class Email {

    private Map<String,String> email = new HashMap<>();
    
    public Email() {
        
    }

    public Email(Map<String, String> email) {
        this.email = email;
    }

    public Map<String, String> getEmail() {
        return email;
    }

    public void setEmail(Map<String, String> email) {
        this.email = email;
    }
        
}
