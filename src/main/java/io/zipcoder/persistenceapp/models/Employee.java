package io.zipcoder.persistenceapp.models;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Long id;
    String firstName;
    String lastName;
    String title;
    String phoneNumber;
    String email;
//    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    Date hireDate;
    @ManyToOne
    Employee manager;
    @ManyToOne
    Department department;

    public Employee() {
    }

    public Employee(Long id, String firstName, String lastName, String title, String phoneNumber, String email, Date hireDate, Employee manager, Department department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.manager = manager;
        this.department = department;
    }

    public Employee(Employee employee) {
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.title = employee.getTitle();
        this.phoneNumber = employee.getPhoneNumber();
        this.email = employee.getEmail();
        this.hireDate = employee.getHireDate();
        this.department = employee.getDepartment();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Employee getManager() {return manager;}

    public void setManager(Employee manager) {this.manager = manager;}

    public Department getDepartment() {return department;}

    public void setDepartment(Department department) {this.department = department;}
}
