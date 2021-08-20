package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees/{managerId}")
    public ResponseEntity<Iterable<Employee>> findAllByManager(@PathVariable Long managerId) {
        return new ResponseEntity<>(service.findAllByManager(managerId), HttpStatus.OK);
    }

    @GetMapping("/employees/noManager")
    public ResponseEntity<Iterable<Employee>> findAllWithoutManager() {
        return new ResponseEntity<>(service.findAllWithoutManager(), HttpStatus.OK);
    }

    @GetMapping("/getManagers/{employeeId}")
    public ResponseEntity<Iterable<Employee>> findManagerHierarchy(@PathVariable Long employeeId) {
        return new ResponseEntity<>(service.findManagerHierarchy(employeeId), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(service.update(id, employee), HttpStatus.CREATED);
    }

    @PutMapping("/updateManager/{employeeId}/{managerId}")
    public ResponseEntity<Employee> updateManager(@PathVariable Long employeeId, @PathVariable Long managerId) {
        return new ResponseEntity<>(service.updateManager(employeeId, managerId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
