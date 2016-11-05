package ch.heigvd.amt.bootcamp2.rest.dto;

/**
 * User representation excluding password
 * 
 * @author Lucie Steiner
 */
public class UserDTO {

   private String username;
   private String firstName;
   private String lastName;
   private String email;

   public UserDTO() {
   }

   public UserDTO(String username, String firstName, String lastName, String email) {
      this.username = username;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public String getUsername() {
      return username;
   }

   public String getFirstName() {
      return firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
