package ch.heigvd.amt.bootcamp2.rest.dto;

/**
 * User representation including password, used for registration
 * 
 * @author Lucie
 */
public class UserRegistrationDTO extends UserDTO {

   private String password;

   public UserRegistrationDTO() {
      super();
   }

   public UserRegistrationDTO(String username, String firstName, String lastName, String email, String password) {
      super(username, firstName, lastName, email);
      this.password = password;
   }

   public String getPassword() { return password; }

}
