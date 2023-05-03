package ca.sledunois.resources;

import ca.sledunois.model.Employee;
import ca.sledunois.repository.EmployeeRepository;
import ca.sledunois.repository.HiveRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Objects;

@Path("/hives/{hiveId}/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource
{

    @Inject
    EmployeeRepository repository;

    @Inject
    HiveRepository hiveRepository;

    @GET
    public List<Employee> list(@PathParam("hiveId") Long hiveId)
    {
        return repository.findByHive(hiveId);
    }

    @POST
    @Transactional
    public Response create(@PathParam("hiveId") Long hiveId, Employee employee)
    {
        var hive = hiveRepository.findById(hiveId);
        if (Objects.isNull(hive))
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        employee.setHive(hive);
        repository.persist(employee);
        return Response.ok(employee).status(Response.Status.CREATED).build();
    }
}
