package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/create/employee")
    public ResponseEntity<Employee> create(Employee employee) {
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

}
