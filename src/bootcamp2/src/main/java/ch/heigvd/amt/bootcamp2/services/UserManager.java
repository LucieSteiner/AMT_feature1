package ch.heigvd.amt.bootcamp2.services;

import ch.heigvd.amt.bootcamp2.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.Singleton;

/**
 *
 * @author Lucie
 */
@Singleton
public class UserManager {
   
   Map<String, User> users = new TreeMap<String, User>();
   
   public boolean checkLogin(String username, String password){
      User user = users.get(username);
      return user != null && user.getPassword().equals(password);

   }
   public boolean register(User user){
      if(!users.containsKey(user.getUsername())){
         users.put(user.getUsername(), user);
         return true;
      }
      return false;
   }
   public List<User> findAllUsers(){
     return new ArrayList(users.values());
   }
   public User loadUser(String username){
      return users.get(username);
   }
   public void updateUser(User user){
      users.replace(user.getUsername(), user);
   }

   public void deleteUser(String username) {
      users.remove(username);
   }
}

