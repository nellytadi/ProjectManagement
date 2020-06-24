package ng.whycode.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ng.whycode.pma.dto.IEmployeeProject;
import ng.whycode.pma.entites.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee,Long>{
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT  e.first_name as firstName, e.last_name as lastName, COUNT(pe.EMPLOYEE_ID )  as projectCount FROM EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON pe.EMPLOYEE_ID = e.EMPLOYEE_ID GROUP BY  e.first_name, e.last_name ORDER BY 3 DESC")
	public List<IEmployeeProject> employeeProjects();
}
