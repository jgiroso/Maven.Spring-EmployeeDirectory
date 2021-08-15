package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/API")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/create/dept")
    public ResponseEntity<Department> create(Department department) {
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }
}
