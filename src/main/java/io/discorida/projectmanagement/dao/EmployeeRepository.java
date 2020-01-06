package io.discorida.projectmanagement.dao;

import io.discorida.projectmanagement.entities.Employee;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

List<Employee> findAll();
}
