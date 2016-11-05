package ch.heigvd.amt.bootcamp2.services;

import ch.heigvd.amt.bootcamp2.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 * Defines the interaction with the database
 * 
 * @author Lucie
 */
@Stateless
public class UserManager {

   @Resource(lookup = "jdbc/amt")
   private DataSource dataSource;
   
   /**
    * Search for a user by username in the database and returns all information about it if it is found
    * @param username 
    * @return the user if found, null otherwise
    */
   public User findOne(String username) {
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE username='" + username + "';");
         ResultSet result = query.executeQuery();
         if (result.next()) {
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String email = result.getString("email");
            String password = result.getString("password");
            User user = new User(username, password, firstName, lastName, email);
            return user;
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return null;
   }
   
   /**
    * Inserts a new user in the database, used for registration
    * 
    * @param user
    * @return true if the insertion has succeeded, false if the user already existed
    */
   public boolean create(User user) {
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement statement = connection.prepareStatement("INSERT INTO user (username, firstName, lastName, email, password)"
                 + "VALUES('" + user.getUsername() + "','" + user.getFirstName() + "','" + user.getLastName() + "','" + user.getEmail() + "','" + user.getPassword() + "');");
         statement.executeUpdate();
         return true;
      } catch (SQLException ex) {
         return false;
      }
   }
   
   /**
    * Retrieves all users from the database
    * 
    * @return list of all users
    */
   public List<User> findAllUsers() {
      ArrayList<User> users = new ArrayList<>();
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement query = connection.prepareStatement("SELECT * FROM user;");
         ResultSet result = query.executeQuery();
         while (result.next()) {
            String username = result.getString("username");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String email = result.getString("email");
            String password = result.getString("password");
            users.add(new User(username, password, firstName, lastName, email));
         }
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return users;
   }

   /**
    * Replaces the user's information with the information of the User provided
    * 
    * @param user User with updated fields
    */
   public void update(User user) {
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement statement = connection.prepareStatement("UPDATE user "
                 + "SET firstName='" + user.getFirstName() + "',"
                 + "lastName='" + user.getLastName() + "',"
                 + "email='" + user.getEmail() + "',"
                 + "password='" + user.getPassword() + "'"
                 + "WHERE username='" + user.getUsername() + "';");
         statement.executeUpdate();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   /**
    * Deletes a user form the database, if it exists
    * 
    * @param username
    */
   public void delete(String username) {
      try (Connection connection = dataSource.getConnection()) {
         PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE username='" + username + "';");
         statement.executeUpdate();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
