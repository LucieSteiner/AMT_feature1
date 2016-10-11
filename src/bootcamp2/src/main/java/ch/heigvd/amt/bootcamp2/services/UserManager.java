/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp2.services;

import ch.heigvd.amt.bootcamp2.model.User;
import java.util.Map;
import java.util.TreeMap;
import javax.ejb.Singleton;

/**
 *
 * @author Lucie
 */
@Singleton
public class UserManager {
   
   Map<String, User> users = new TreeMap<String, User>();;
   
   public boolean checkLogin(String username, String password){
      User user = users.get(username);
      return user != null && user.getPassword().equals(password);

   }
   public boolean register(String username, String password){
      if(!users.containsKey(username)){
         users.put(username, new User(username, password));
         return true;
      }
      return false;
   }
}

