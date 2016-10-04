/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp2.services;

import ch.heigvd.amt.bootcamp2.model.User;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Lucie
 */
public class UserManager {
   private static UserManager instance = null;
   Map<String, User> users = new TreeMap<String, User>();;
   protected UserManager(){
      
   }
   public static UserManager getInstance(){
      if(instance == null){
         instance = new UserManager();
      }
      return instance;
   }
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

