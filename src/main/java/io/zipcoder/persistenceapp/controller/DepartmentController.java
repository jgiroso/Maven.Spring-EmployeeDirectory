package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/API/dept")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Department>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Department> update(@PathVariable Long id, @RequestBody Department department) {
        return new ResponseEntity<>(service.update(id, department), HttpStatus.CREATED);
    }

    @PutMapping("/updateManager/{departmentId}/{managerId}")
    public ResponseEntity<Department> updateManager(@PathVariable Long departmentId, @PathVariable Long managerId) {
        return new ResponseEntity<>(service.updateManager(departmentId, managerId), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Department> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
