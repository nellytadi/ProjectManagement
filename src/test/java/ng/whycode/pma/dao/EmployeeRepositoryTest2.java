package ng.whycode.pma.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ng.whycode.pma.entites.Employee;


@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeRepositoryTest2 {

	@Autowired
	IEmployeeRepository empRepo;
	
	@Test
	public void ifNewEmployeeIsSaved_ThenSuccess() {
		
		Employee employee = new Employee("Jamie Lanister","jamie@gmail.com",14);
		empRepo.save(employee);
		Employee employee1 = new Employee("Davie Lanister","damie@gmail.com",39);
		empRepo.save(employee1);
		System.out.println(empRepo.findAll().size());
		assertEquals(2,empRepo.findAll().size());
	}

}
