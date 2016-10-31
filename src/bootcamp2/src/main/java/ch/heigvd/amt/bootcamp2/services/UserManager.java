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
 *
 * @author Lucie
 */
@Stateless
public class UserManager {
   @Resource(lookup = "jdbc/amt")
   private DataSource dataSource;
   
   public User findOne(String username){
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement query = connection.prepareStatement("SELECT * FROM user WHERE username='"+username+"';");
         ResultSet result = query.executeQuery();
         if(result.next()){
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
   public boolean create(User user){
      int result = 0;
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement("INSERT INTO user (username, firstName, lastName, email, password)"
                 + "VALUES('"+user.getUsername()+"','"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPassword()+"');");
         result = statement.executeUpdate();
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
      return result == 1;
   }
   public List<User> findAllUsers(){
     ArrayList<User> users = new ArrayList<>();
     try {
         Connection connection = dataSource.getConnection();
         PreparedStatement query = connection.prepareStatement("SELECT * FROM user;");
         ResultSet result = query.executeQuery();
         while(result.next()){
            String username = result.getString("username");
            String firstName = result.getString("firstName");
            String lastName = result.getString("lastName");
            String email = result.getString("email");
            String password = result.getString("password");
            users.add(new User(username, firstName, lastName, email, password));
         }
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
     return users;
   }
   public void update(User user){
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement("UPDATE user "
                 + "SET firstName='"+user.getFirstName()+"',"
                 + "lastName='"+user.getLastName()+"',"
                 + "email='"+user.getEmail()+"',"
                 + "password='"+user.getPassword()+"'"
                 + "WHERE username='"+user.getUsername()+"';");
         statement.executeUpdate();
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void delete(String username) {
      try {
         Connection connection = dataSource.getConnection();
         PreparedStatement statement = connection.prepareStatement("DELETE FROM user WHERE username='"+username+"';");
         statement.executeUpdate();
         connection.close();
      } catch (SQLException ex) {
         Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}

