package ch.heigvd.amt.bootcamp2.model;

/**
 *
 * @author Lucie
 */
public class User {
   private String username;
   private String password;
   private String firstName;
   private String lastName;
   private String email;
   
   public String getUsername(){
      return username;
   }
   public String getPassword(){
      return password;
   }
   public String getFirstName(){
      return firstName;
   }
   public String getLastName(){
      return lastName;
   }
   public String getEmail(){
      return email;
   }
   public User(String username, String password, String firstName, String lastName, String email){
      this.username = username;
      this.password = password;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
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
   
   public void setPassword(String password) {
      this.password = password;
   }
   
}
