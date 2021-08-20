package io.zipcoder.persistenceapp.models;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String name;
    @OneToOne(cascade=CascadeType.ALL)
    Employee departmentManager;

    public Department() {
    }

    public Department(Long id, String name, Employee departmentManager) {
        this.id = id;
        this.name = name;
        this.departmentManager = departmentManager;
    }

    public Department(Department department) {
        this.name = department.getName();
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

    public Employee getDepartmentManager() {return departmentManager;}

    public void setDepartmentManager(Employee departmentManager) {this.departmentManager = departmentManager;}
}
