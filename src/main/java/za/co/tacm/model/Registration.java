package za.co.tacm.model;

public class Registration {
    
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

       
}
