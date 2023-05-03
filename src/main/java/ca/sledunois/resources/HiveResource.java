package ca.sledunois.resources;

import java.util.List;

import ca.sledunois.model.Hive;
import ca.sledunois.repository.HiveRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response;

@Path("/hives")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HiveResource {

  @Inject
  HiveRepository repository;

  @GET
  public List<Hive> list() {
    return repository.listAll();
  }

  @POST
  @Transactional
  public Hive create(Hive aNewHive) {
    repository.persist(aNewHive);
    return aNewHive;
  }

  @DELETE
  @Path("/{id}")
  @Transactional
  @Produces(MediaType.APPLICATION_JSON)
  public Response delete(@PathParam("id") Long id) {
    var deleted = repository.deleteById(id);
    return deleted ? Response.ok().status(Status.NO_CONTENT).build() : Response.ok().status(Status.NOT_FOUND).build();
  }
}
