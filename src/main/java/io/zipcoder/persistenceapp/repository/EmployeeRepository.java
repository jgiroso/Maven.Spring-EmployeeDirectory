package io.zipcoder.persistenceapp.repository;

import io.zipcoder.persistenceapp.models.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT * FROM EMPLOYEE e WHERE e.FIRST_NAME = :name", nativeQuery = true)
    List<Employee> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM EMPLOYEE e WHERE e.MANAGER_ID = :managerId", nativeQuery = true)
    List<Employee> findAllByManager(@Param("managerId") Long managerId);

    @Query(value = "SELECT * FROM EMPLOYEE e WHERE e.MANAGER_ID = null", nativeQuery = true)
    List<Employee> findAllWithoutManager();



}
