package ng.whycode.dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import ng.whycode.pma.dao.IProjectRepository;
import ng.whycode.pma.entites.Project;

//starting point of application so it loads beans 
@ContextConfiguration(classes=PmAppApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD,scripts= {"classpath:schema.sql","classpath:data.sql"}),
			@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD,scripts= "classpath:drop.sql")
			})
public class ProjectRepositoryIntegrationTest {

	@Autowired
	IProjectRepository proRepo;
	
	@Test
	public void ifNewProjectIsSaved_ThenSuccess() throws ParseException {
		Date startDate=new SimpleDateFormat("dd-MM-yyyy").parse("01-07-2020");
		Date endDate=new SimpleDateFormat("dd-MM-yyyy").parse("30-07-2020");
		Project project = new Project("First Test Project","COMPLETED","This is the first project description",startDate,endDate);
		
		proRepo.save(project);
		
		assertEquals(5,proRepo.findAll().size());
	}

}
