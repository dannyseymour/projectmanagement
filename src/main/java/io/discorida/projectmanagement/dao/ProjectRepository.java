package io.discorida.projectmanagement.dao;

import io.discorida.projectmanagement.dto.ChartData;
import io.discorida.projectmanagement.entities.Project;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();

  @Query(nativeQuery = true, value="SELECT stage as label, COUNT(*) as value FROM project GROUP BY stage")
  public List<ChartData> getProjectStatus();


}
