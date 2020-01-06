package io.discorida.projectmanagement.controllers;

import io.discorida.projectmanagement.dao.EmployeeRepository;
import io.discorida.projectmanagement.dao.ProjectRepository;
import io.discorida.projectmanagement.entities.Employee;
import io.discorida.projectmanagement.entities.Project;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  private ProjectRepository projectRepository;
  private EmployeeRepository employeeRepository;

  @Autowired
  public HomeController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
    this.projectRepository = projectRepository;
    this.employeeRepository = employeeRepository;
  }

  @GetMapping("/")
  public String displayHome(Model model){
    List<Project> projects = projectRepository.findAll();
    model.addAttribute("projects", projects);
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("employees", employees);
    return "home";
  }
}
