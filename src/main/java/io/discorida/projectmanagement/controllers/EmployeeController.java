package io.discorida.projectmanagement.controllers;

import io.discorida.projectmanagement.dao.EmployeeRepository;
import io.discorida.projectmanagement.entities.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/employees")
@Controller
public class EmployeeController {


  private EmployeeRepository employeeRepository;

  @GetMapping
  public String displayEmployees(Model model){
    List<Employee> employeeList = employeeRepository.findAll();
    model.addAttribute("employees", employeeList);
    return "/employees/list-employees";
  }

  @Autowired
  public EmployeeController(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @RequestMapping("/new")
  public String displayEmployeeForm(Model model){
    Employee newEmployee = new Employee();
    model.addAttribute("employee", newEmployee);
    return "/employees/new-employee";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProject(Employee employee, Model model){
    employeeRepository.save(employee);
    return "redirect:/employees/";
  }


}
