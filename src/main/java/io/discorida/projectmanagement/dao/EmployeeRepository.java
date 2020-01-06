package io.discorida.projectmanagement.dao;

import io.discorida.projectmanagement.dto.EmployeeProject;
import io.discorida.projectmanagement.entities.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  public List<Employee> findAll();

  @Query(nativeQuery = true, value="SELECT e.first_name as firstName, e.last_name as lastName,  COUNT(pe.employee_id) as projectCount FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id GROUP BY e.first_name, e.last_name")
  public List<EmployeeProject> employeeProjects();
}
