package ca.sledunois.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "hive")
public class Hive extends PanacheEntity
{
    private String location;

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }
}
