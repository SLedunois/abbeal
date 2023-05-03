package ca.sledunois.repository;

import ca.sledunois.model.Hive;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HiveRepository implements PanacheRepository<Hive> {

}
