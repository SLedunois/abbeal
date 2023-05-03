package ca.sledunois.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends PanacheEntity
{

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "hive_id", nullable = false)
    private Hive hive;

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setHive(Hive hive)
    {
        this.hive = hive;
    }

    public Hive getHive()
    {
        return this.hive;
    }

}
