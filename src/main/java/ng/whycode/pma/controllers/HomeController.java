package ng.whycode.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.dao.IProjectRepository;
import ng.whycode.pma.dto.IEmployeeProject;
import ng.whycode.pma.dto.IProjectStage;
import ng.whycode.pma.entites.Project;

@Controller
public class HomeController {
	@Value("${version}")
	private String version;
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;

	@GetMapping("/")
	public String displayHome(Model model) {
		model.addAttribute("version",version);
		
		List <Project> projects = proRepo.findAll();
		model.addAttribute("projects",projects);
		
		List<IEmployeeProject> employeesProjectCount = empRepo.employeeProjects();
		model.addAttribute("employeesProjectCount",employeesProjectCount);
		
		List<IProjectStage> projectStageCount = proRepo.projectStage();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonString = mapper.writeValueAsString(projectStageCount);
			model.addAttribute("chartData",jsonString);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return "main/home";
	}
	
}
