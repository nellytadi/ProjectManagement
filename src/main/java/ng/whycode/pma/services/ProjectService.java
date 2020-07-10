package ng.whycode.pma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ng.whycode.pma.dao.IProjectRepository;
import ng.whycode.pma.dto.IProjectStage;
import ng.whycode.pma.entites.Project;

@Service
public class ProjectService {

	IProjectRepository proRepo;
	
	public Project save(Project project) {
		return proRepo.save(project);
	}
	
	public List<Project> getAll(){
		return proRepo.findAll();
	}
	
	public List<IProjectStage> projectStage(){
		return proRepo.projectStage();
	}
}
