package io.discorida.projectmanagement.controllers;

import io.discorida.projectmanagement.dao.ProjectRepository;
import io.discorida.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/projects")
public class ProjectController {


  private ProjectRepository projectRepository;

  @Autowired
  public ProjectController(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @RequestMapping("/new")
  public String displayProjectForm(Model model){
    Project aProject = new Project();
    model.addAttribute("project", aProject);
    return "new-project";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String saveProject(Project project, Model model){
    projectRepository.save(project);
    return "redirect:/projects/new";
}

}
