package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public Department create(Department department) {
        Department retVal = new Department(department);

        if(department.getDepartmentManager() != null) {
            Employee departmentManager = new Employee(department.getDepartmentManager());
            List<Employee> managerList = employeeRepository.findByName(departmentManager.getFirstName());
            Long managerId = managerList.get(0).getId();
            retVal = assignManager(managerId, retVal);
        }

        return departmentRepository.save(retVal);
    }

    private Department assignManager(Long managerId, Department retVal) {
        Employee departmentManager = employeeRepository.findOne(managerId);
        if(departmentManager != null) {
            retVal.setDepartmentManager(departmentManager);
        }
        return retVal;
    }

    public Department findById(Long id) {
        return departmentRepository.findOne(id);
    }

    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department update(Long id, Department newDepartment) {
        Department department = departmentRepository.findOne(id);
        department.setName(newDepartment.getName());
        department.setDepartmentManager(newDepartment.getDepartmentManager());
        return departmentRepository.save(department);
    }

    public Department delete(Long id) {
        Department department = departmentRepository.findOne(id);
        departmentRepository.delete(id);
        return department;
    }

    public Department updateManager(Long departmentId, Long managerId) {
        Department departmentRetVal = departmentRepository.findOne(departmentId);
        departmentRetVal = assignManager(managerId, departmentRetVal);

        return departmentRepository.save(departmentRetVal);
    }
}
