package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    @OneToOne(cascade=CascadeType.ALL)
    Employee manager;

    public Department() {
    }

    public Department(Long id, String name, Employee manager) {
        this.id = id;
        this.name = name;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {return manager;}

    public void setManager(Employee manager) {this.manager = manager;}
}
