package ng.whycode.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ng.whycode.pma.dto.IProjectStage;
import ng.whycode.pma.entites.Project;

public interface IProjectRepository extends CrudRepository<Project,Long>{
	@Override
	public List <Project> findAll();
	
	@Query(nativeQuery=true, value="SELECT STAGE as label,COUNT(STAGE ) as value FROM PROJECT  GROUP BY STAGE")
	public List <IProjectStage> projectStage();
}
