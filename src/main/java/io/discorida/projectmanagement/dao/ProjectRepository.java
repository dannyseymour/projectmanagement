package io.discorida.projectmanagement.dao;

import io.discorida.projectmanagement.entities.Project;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();
}
