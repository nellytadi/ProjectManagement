package ng.whycode.pma.controllers;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.dao.IProjectRepository;
import ng.whycode.pma.entites.Employee;
import ng.whycode.pma.entites.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	//@Autowired causes spring to instantiate a class / interface creating an anonymous class
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping("/create")
	public String displayProjectForm(Model model) {
		//Model - bind data to the view
		
		Project project = new Project();
		List <Employee> employees =  empRepo.findAll();
		model.addAttribute("allEmployees",employees);
		model.addAttribute("project", project);
		
		return "project/create-project";
	}


	@PostMapping("/store")
	public String storeProject(@Valid Project project, Errors error,Model model) {

		if(error.hasErrors()) {
			List <Employee> employees =  empRepo.findAll();
			model.addAttribute("allEmployees",employees);
			return "project/create-project";
		}
		
		proRepo.save(project);
		
		//use redirect to prevent duplicate submissions
		return "redirect:/project";
		
		
	}

	@GetMapping
	public String displayList(Model model) {
		List <Project> projects = proRepo.findAll();
		
		model.addAttribute("projects", projects);
		
		return "project/project-list";
		
	}
	
	
	@GetMapping("/update")
	public String updateProject(Model model, @RequestParam Long id) {
		
		Project project = proRepo.findById(id).get();
		List <Employee> employees =  empRepo.findAll();
		model.addAttribute("allEmployees",employees);
		model.addAttribute("project", project);
		
		return "project/create-project";
		
	}
	
	@GetMapping("/delete")
	public String deleteProject(Model model, @RequestParam Long id) {
		
		 proRepo.deleteById(id);;
		
		 return "redirect:/project";
		
	}
	
}
