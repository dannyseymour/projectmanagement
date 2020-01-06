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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/projects")
public class ProjectController {


  private ProjectRepository projectRepository;
  private EmployeeRepository employeeRepository;

  @Autowired
  public ProjectController(ProjectRepository projectRepository, EmployeeRepository employeeRepository) {
    this.projectRepository = projectRepository;
    this.employeeRepository = employeeRepository;
  }

  @GetMapping
  public String displayProjects(Model model){
    List<Project> projectList = projectRepository.findAll();
    model.addAttribute("projects", projectList);
    return "/projects/list-projects";
  }


  @RequestMapping("/new")
  public String displayProjectForm(Model model){
    Project aProject = new Project();
    List<Employee> employees = employeeRepository.findAll();
    model.addAttribute("project", aProject);
    model.addAttribute("allEmployees", employees);
    return "projects/new-project";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProject(Project project, Model model){
    projectRepository.save(project);


    return "redirect:/projects/";
}



}
