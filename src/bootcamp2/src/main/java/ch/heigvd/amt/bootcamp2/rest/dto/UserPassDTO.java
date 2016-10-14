package ch.heigvd.amt.bootcamp2.rest.dto;

/**
 *
 * @author Lucie
 */
public class UserPassDTO extends UserDTO{
   private String password;
   public UserPassDTO(){
      super();
   }
   public UserPassDTO(String username, String firstName, String lastName, String email, String password){
      super(username, firstName, lastName, email);
      this.password = password;
   }
   public String getPassword(){
      return password;
   }
   public void setPassword(){
      this.password = password;
   }
   
}
