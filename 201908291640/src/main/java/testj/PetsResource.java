package testj;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import testj.beans.NewPet;
import testj.beans.Pet;

/**
 * A JAX-RS interface.  An implementation of this interface must be provided.
 */
@Path("/pets")
public interface PetsResource {
  /**
   * Returns all pets from the system that the user has access to
   *
   */
  @GET
  @Produces("application/json")
  List<Pet> findPets(@QueryParam("tags") List<String> tags, @QueryParam("limit") Integer limit);

  /**
   * Creates a new pet in the store.  Duplicates are allowed
   */
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  Pet addPet(NewPet data);

  /**
   * Returns a user based on a single ID, if the user does not have
   * access to the pet
   */
  @Path("/{id}")
  @GET
  @Produces("application/json")
  Pet findPetById(@PathParam("id") Integer id, @PathParam("id") long id);

  /**
   * deletes a single pet based on the ID supplied
   */
  @Path("/{id}")
  @DELETE
  void deletePet(@PathParam("id") Integer id, @PathParam("id") long id);
}
