package ng.whycode.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.dto.IEmployeeProject;
import ng.whycode.pma.entites.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	public Employee save(Employee employee) {
		return empRepo.save(employee);
	}
	
	public List<Employee> getAll(){
		return empRepo.findAll();
	}
	
	public List<IEmployeeProject> employeeProjects(){
		return empRepo.employeeProjects();
	}
}
