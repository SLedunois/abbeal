package ca.sledunois.repository;

import ca.sledunois.model.Employee;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public List<Employee> findByHive(Long hiveId) {
        return list("hive.id = :hiveId", Parameters.with("hiveId", hiveId));
    }

}
