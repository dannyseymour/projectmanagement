package io.discorida.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.discorida.projectmanagement.dao.EmployeeRepository;
import io.discorida.projectmanagement.dao.ProjectRepository;
import io.discorida.projectmanagement.dto.ChartData;
import io.discorida.projectmanagement.dto.EmployeeProject;
import io.discorida.projectmanagement.entities.Employee;
import io.discorida.projectmanagement.entities.Project;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
  public String displayHome(Model model) throws JsonProcessingException {
    Map<String, Object> map = new HashMap<>();

    List<Project> projects = projectRepository.findAll();
    model.addAttribute("projects", projects);

    List<ChartData> projectData = projectRepository.getProjectStatus();
    //object mapper- convert to JSON

    ObjectMapper objectMapper = new ObjectMapper();
   String jsonString =  objectMapper.writeValueAsString(projectData);

   model.addAttribute("projectStatusCount", jsonString);

    List<EmployeeProject> employeeProjectsCount = employeeRepository.employeeProjects();
    model.addAttribute("employeeListProjectsCount", employeeProjectsCount);
    return "main/home";
  }
}
