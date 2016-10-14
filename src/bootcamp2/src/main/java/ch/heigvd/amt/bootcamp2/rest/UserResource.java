package ch.heigvd.amt.bootcamp2.rest;

import ch.heigvd.amt.bootcamp2.model.User;
import ch.heigvd.amt.bootcamp2.rest.dto.UserDTO;
import ch.heigvd.amt.bootcamp2.rest.dto.UserPassDTO;
import ch.heigvd.amt.bootcamp2.services.UserManager;
import java.net.URI;
import java.util.List;
import static java.util.stream.Collectors.toList;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Lucie
 */
@Stateless
@Path("/users")
public class UserResource {
   @EJB
  private UserManager userManager;

  @Context
  UriInfo uriInfo;
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<UserDTO> getPeople(@QueryParam(value = "byName" ) String byName) {
    List<User> users = userManager.findAllUsers();
    return users.stream()
      .filter(p -> byName == null || p.getUsername().equalsIgnoreCase(byName))
      .map(p -> toDTO(p))
      .collect(toList());
      
  }
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response createUser(UserPassDTO userDTO) {
    User user = fromDTO(userDTO);
    userManager.register(user);
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
  
  @Path("{id}")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public UserDTO getUser(@PathParam(value = "id") String username) {
    User user = userManager.loadUser(username);
    return toDTO(user);
  }
  public User fromDTO(UserPassDTO dto) {
    return new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
  }
  public UserDTO toDTO(User user) {
    UserDTO dto = new UserDTO(user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail());
    return dto;
  }
}