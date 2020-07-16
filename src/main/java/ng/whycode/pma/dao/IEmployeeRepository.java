package ng.whycode.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ng.whycode.pma.dto.IEmployeeProject;
import ng.whycode.pma.entites.Employee;

@RepositoryRestResource(collectionResourceRel="api-employees",path="api-employees")
public interface IEmployeeRepository extends PagingAndSortingRepository<Employee,Long>{
	@Override
	public List<Employee> findAll();
	
	@Query(nativeQuery=true, value="SELECT  e.full_name as fullName, COUNT(pe.EMPLOYEE_ID )  as projectCount FROM EMPLOYEE e LEFT JOIN PROJECT_EMPLOYEE pe ON pe.EMPLOYEE_ID = e.EMPLOYEE_ID GROUP BY  e.employee_id ORDER BY e.employee_id DESC")
	public List<IEmployeeProject> employeeProjects();
	
	public Employee findByEmail(String value);
}
