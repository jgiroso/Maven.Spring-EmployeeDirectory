package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee findById(Long id) {
        return repository.findOne(id);
    }

    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    public Employee update(Long id, Employee newEmployee) {
        Employee employee = repository.findOne(id);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setTitle(newEmployee.getTitle());
        employee.setPhoneNumber(newEmployee.getPhoneNumber());
        employee.setEmail(newEmployee.getEmail());
        employee.setHireDate(newEmployee.getHireDate());
        return repository.save(employee);
    }

    public Employee delete(Long id) {
        Employee employee = repository.findOne(id);
        repository.delete(id);
        return employee;
    }
}
