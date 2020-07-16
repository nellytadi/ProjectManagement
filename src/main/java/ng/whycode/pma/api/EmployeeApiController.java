package ng.whycode.pma.api;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.entites.Employee;

@RequestMapping("/api/employee")
@RestController
public class EmployeeApiController {

	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping
	public Iterable<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	 
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return empRepo.findById(id).get();
	} 
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee createEmployee(@RequestBody @Valid Employee employee) {
			
		return empRepo.save(employee);

	}
	
	
	@PutMapping(path="/update",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee updateEmployee(@RequestBody @Valid Employee employee) {
		return empRepo.save(employee);
	
	}
	
	@PutMapping(path="/updates",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public List <Employee> updateEmployee(@RequestBody @Valid  List <Employee> employees) {
		
		List <Employee> updatedEmployees = new ArrayList <Employee>();
		for(Employee emp : employees) {
			empRepo.save(emp);
		}
		return updatedEmployees;
	
	}
	
	@PatchMapping(path="/update/{id}",consumes="application/json")
	@ResponseStatus(HttpStatus.OK)
	public Employee updatePatchEmployee(@PathVariable("id") Long id, @RequestBody @Valid Employee employee) {
		
		Employee emp= empRepo.findById(id).get();
		if(employee.getFullName() != null) {
			emp.setFullName(employee.getFullName());
		}
		if(employee.getEmail() != null) {
			emp.setEmail(employee.getEmail());
		}
		if(employee.getAge() <=  0) {
			emp.setAge(employee.getAge());
		}
		
		return empRepo.save(emp);
	}
	
	@DeleteMapping(path="/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") Long id) {
		try {
			empRepo.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {	
			
		}
		
		
	
	}
	
	
	@GetMapping(path="/all",params= {"page","size"})
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Employee> findPaginatedEmployees(@RequestParam("page") int page, @RequestParam("size") int size) {
		Pageable pageAndSize = PageRequest.of(page,size);
		return empRepo.findAll(pageAndSize);
	} 
}
