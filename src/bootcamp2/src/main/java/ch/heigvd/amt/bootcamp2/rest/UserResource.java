package ch.heigvd.amt.bootcamp2.rest;

import ch.heigvd.amt.bootcamp2.model.User;
import ch.heigvd.amt.bootcamp2.rest.dto.UserDTO;
import ch.heigvd.amt.bootcamp2.rest.dto.UserRegistrationDTO;
import ch.heigvd.amt.bootcamp2.services.UserManager;
import java.net.URI;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Defines all operations that can be done with the REST API
 * 
 * @author Lucie Steiner
 */
@Stateless
@Path("/users")
public class UserResource {

   @EJB
   private UserManager userManager;

   @Context
   UriInfo uriInfo;

   /**
    * Lists all information about all users, except their password
    * @param byName 
    * @return 
    */
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<UserDTO> getUsers(@QueryParam(value = "byName") String byName) {
      List<User> users = userManager.findAllUsers();
      return users.stream()
              .filter(p -> byName == null || p.getUsername().equalsIgnoreCase(byName))
              .map(p -> toDTO(p))
              .collect(toList());
   }

   /**
    * Creates a new user and inserts it in the database
    * @param userDTO contains all the information about the user, including the password
    * @return 
    */
   @POST
   @Consumes(MediaType.APPLICATION_JSON)
   public Response createUser(UserRegistrationDTO userDTO) {
      User user = fromDTO(userDTO);
      userManager.create(user);
      String username = user.getUsername();
      URI href = uriInfo
              .getBaseUriBuilder()
              .path(UserResource.class)
              .path(UserResource.class, "getUser")
              .build(username);

      return Response
              .created(href)
              .build();
   }

   /**
    * Returns all information about one user, except the password
    * @param username
    * @return 
    */
   @Path("{id}")
   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public UserDTO getUser(@PathParam(value = "id") String username) {
      User user = userManager.findOne(username);
      return toDTO(user);
   }

   /**
    * Allows to change any information about one user, except his username of password
    * @param username
    * @param dto all information about the user, including updated fields
    * @return 
    */
   @Path("{id}")
   @PUT
   @Consumes(MediaType.APPLICATION_JSON)
   public Response updateUser(@PathParam(value = "id") String username, UserDTO dto) {
      User user = userManager.findOne(username);
      user.setFirstName(dto.getFirstName());
      user.setLastName(dto.getLastName());
      user.setEmail(dto.getEmail());
      userManager.update(user);
      return Response
              .accepted()
              .build();
   }

   /**
    * Deletes a user from the database
    * 
    * @param username
    * @return 
    */
   @Path("{id}")
   @DELETE
   public Response deleteUser(@PathParam(value = "id") String username) {
      userManager.delete(username);
      return Response
              .accepted()
              .build();
   }

   /**
    * Changes the password of a user
    * @param username
    * @param dto all the information about the user, including unmodified fields and modified password
    * @return 
    */
   @Path("{id}/password")
   @PUT
   public Response updatePassword(@PathParam(value = "id") String username, UserRegistrationDTO dto) {
      User user = userManager.findOne(username);
      user.setPassword(dto.getPassword());
      userManager.update(user);
      return Response
              .accepted()
              .build();
   }

   /**
    * Creates a User from its JSON representation
    * @param dto JSON representation including the user's password
    * @return 
    */
   public User fromDTO(UserRegistrationDTO dto) {
      return new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
   }
   
   /**
    * Creates a UserDTO from a User
    * @param user
    * @return  JSON representation excluding the user's password
    */
   public UserDTO toDTO(User user) {
      UserDTO dto = new UserDTO(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
      return dto;
   }
}
