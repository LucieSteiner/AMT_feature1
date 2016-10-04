/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp2.model;

/**
 *
 * @author Lucie
 */
public class User {
   private String username;
   private String password;
   
   public String getUsername(){
      return username;
   }
   public String getPassword(){
      return password;
   }
   public User(String username, String password){
      this.username = username;
      this.password = password;
   }
   
}
