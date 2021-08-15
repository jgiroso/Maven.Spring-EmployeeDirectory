package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public Department create(Department department) {
        return repository.save(department);
    }

    public Department findById(Long id) {
        return repository.findOne(id);
    }

}
