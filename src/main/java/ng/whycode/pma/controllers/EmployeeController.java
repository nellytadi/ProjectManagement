package ng.whycode.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.entites.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	IEmployeeRepository empRepo;
	@GetMapping("/create")
	public String displayForm(Model model) {
		Employee employee = new Employee();
		
		model.addAttribute("employee", employee);
		
		return "employee/create-employee";
		
	}
	@PostMapping("/store")
	public String storeData(Model model,Employee employee) {
		empRepo.save(employee);
		return "redirect:/employee/create";
		
	}
	
	@GetMapping
	public String displayList(Model model) {
		List <Employee> employees = empRepo.findAll();
		
		model.addAttribute("employees", employees);
		
		return "employee/employee-list";
		
	}
}