package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;
    private LinkedList<Employee> managerHierarchy;

    public Employee create(Employee employee) {
        Employee retVal = new Employee(employee);

        if(employee.getManager() != null) {
            Employee manager = new Employee(employee.getManager());
            List<Employee> managerList = repository.findByName(manager.getFirstName());
            Long managerId = managerList.get(0).getId();
            retVal = assignManager(managerId, retVal);
        }

        return repository.save(retVal);
    }

    private Employee assignManager(Long managerId, Employee employee) {
        Employee manager = repository.findOne(managerId);
        employee.setManager(manager);
        employee.setDepartment(manager.getDepartment());
        return employee;
    }

    public Employee findById(Long id) {
        return repository.findOne(id);
    }

    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    public Iterable<Employee> findAllByManager(Long managerId) {
        return repository.findAllByManager(managerId);
    }

    public Iterable<Employee> findAllWithoutManager() {
        return repository.findAllWithoutManager();
    }

    public LinkedList<Employee> findManagerHierarchy(Long employeeId) {
        managerHierarchy = new LinkedList<>();
        populateManagerList(employeeId);

        return managerHierarchy;
    }

    private Employee findManager(Long employeeId) {
        return repository.findOne(employeeId).getManager();
    }

    private void populateManagerList(Long employeeId) {
        Employee manager = findManager(employeeId);
        managerHierarchy.add(manager);
        if(manager.getManager() != null) {
            populateManagerList(manager.getId());
        }
    }

    public Employee update(Long id, Employee newEmployee) {
        Employee employee = repository.findOne(id);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setTitle(newEmployee.getTitle());
        employee.setPhoneNumber(newEmployee.getPhoneNumber());
        employee.setEmail(newEmployee.getEmail());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setManager(newEmployee.getManager());
        return repository.save(employee);
    }

    public Employee updateManager(Long employeeId, Long managerId) {
        Employee employeeRetVal = repository.findOne(employeeId);
        employeeRetVal = assignManager(managerId, employeeRetVal);

        return repository.save(employeeRetVal);
    }

    public Employee delete(Long id) {
        Employee employee = repository.findOne(id);
        repository.delete(id);
        return employee;
    }
}
