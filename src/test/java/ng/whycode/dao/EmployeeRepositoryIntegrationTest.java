package ng.whycode.dao;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import ng.whycode.pma.PmAppApplication;
import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.entites.Employee;


//starting point of application so it loads beans 
@ContextConfiguration(classes=PmAppApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts= {"classpath:schema.sql","classpath:data.sql"}),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,scripts= "classpath:drop.sql")
			})
public class EmployeeRepositoryIntegrationTest {

	@Autowired
	IEmployeeRepository empRepo;
	
	@Test
	public void ifNewEmployeeIsSaved_ThenSuccess() {
		
		Employee employee = new Employee("Jamie Lanister","jamie@gmail.com",20);
		empRepo.save(employee);
		System.out.println(empRepo.findAll().size());
		assertEquals(10,empRepo.findAll().size());
	}

}
