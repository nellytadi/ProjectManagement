package ng.whycode.pma;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.dao.IProjectRepository;
import ng.whycode.pma.entites.Employee;
import ng.whycode.pma.entites.Project;

@SpringBootApplication
public class PmAppApplication {
	@Autowired
	IEmployeeRepository empRepo;

	@Autowired
	IProjectRepository proRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PmAppApplication.class, args);
	}
//	@Bean
//	public CommandLineRunner runner() {
//		return args -> {
//				Employee emp1 = new Employee("Jerry","Silas","jerry@gmail.com");
//				Employee emp2 = new Employee("Paulina","Derek","derek@yahoo.com");
//				Employee emp3 = new Employee("Gabriel","Richard","gabriel@rocketmail.com");
//				
//				Employee emp4 = new Employee("Deborah","Tadi","deborah@outlook.com");
//				Employee emp5 = new Employee("Grace","Daniel","grace@gmail.com");
//				Employee emp6 = new Employee("Loco","Kwaffier","loco@gmail.com");
//				
//				Employee emp7 = new Employee("Justina","Donald","justina@gmail.com");
//				Employee emp8 = new Employee("Naphtali","Priscas","naphtali@yahoo.com");
//				Employee emp9 = new Employee("Rachie","Solomon","solomon@gmail.com");
//				
//				
//				Project pro1 = new Project("Building Chatting App","Completed","Building Chatting App for the company");
//				Project pro2 = new Project("Building Cheaters App","NotStarted","Building Cheaters App for the company");
//				Project pro3 = new Project("Implement UI for Chatting App","InProgress","Implementing UI Chatting App for the company");
//				
//				Project pro4 = new Project("Load loaders for Chatting App","NotStarted","Loading loaders Chatting App for the company");
//				Project pro5 = new Project("Design API for Chatting App","InProgress","Designing API Chatting App for the company");
//				Project pro6 = new Project("Building Chatting App","InProgress","Building Chatting App for the company");
//				
//				Project pro7 = new Project("Interfacing Chatting App","NotStarted","Building Chatting App for the company");
//				Project pro8 = new Project("Pulling Chatting App","Completed","Building Chatting App for the company");
//				Project pro9 = new Project("Get new Employees","NotStarted","Hire new Employees for the company. This needs all on deck");
//				
//				pro1.addEmployee(emp1);
//				pro2.addEmployee(emp2);
//				pro3.addEmployee(emp3);
//				pro4.addEmployee(emp4);
//				pro5.addEmployee(emp5);
//				pro6.addEmployee(emp6);
//				pro7.addEmployee(emp7);
//				pro8.addEmployee(emp8);
//				pro9.addEmployee(emp9);
//				
//				emp1.setProjects(Arrays.asList(pro1,pro6,pro7));
//				emp2.setProjects(Arrays.asList(pro6,pro3,pro4));
//				emp3.setProjects(Arrays.asList(pro3,pro2,pro8));
//				emp4.setProjects(Arrays.asList(pro1,pro9));
//				emp5.setProjects(Arrays.asList(pro5,pro9,pro6));
//				emp6.setProjects(Arrays.asList(pro2));
//				emp7.setProjects(Arrays.asList(pro7,pro2,pro4));
//				emp8.setProjects(Arrays.asList(pro9,pro3));
//				emp9.setProjects(Arrays.asList(pro2,pro5));
//				
//				empRepo.save(emp1);
//				empRepo.save(emp2);
//				empRepo.save(emp3);
//				empRepo.save(emp4);
//				empRepo.save(emp5);
//				empRepo.save(emp6);
//				empRepo.save(emp7);
//				empRepo.save(emp8);
//				empRepo.save(emp9);
//				
//				proRepo.save(pro1);
//				proRepo.save(pro2);
//				proRepo.save(pro3);
//				proRepo.save(pro4);
//				proRepo.save(pro5);
//				proRepo.save(pro6);
//				proRepo.save(pro7);
//				proRepo.save(pro8);
//				proRepo.save(pro9);
//				
//		};
//		
//		
//	}
}
