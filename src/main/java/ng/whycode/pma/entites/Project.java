package ng.whycode.pma.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Project {
	//AUTO increment is managed by Hibernate
	//Identity Hibernate will rely on db increment - Disadvantage you lose Hibernate batching features eg batch updates on 1000 records 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
	@SequenceGenerator(name = "project_generator", sequenceName = "project_seq", allocationSize = 1)
	private long projectId;
	
	@NotNull
	@Size(min=2,max=100)
	private String name;
	
	@NotNull
	@Size(min=2,max=100)
	private String stage;
	
	@NotNull
	@Size(min=2)
	private String description;
	
	@NotNull(message="date cannot be empty")
	private Date startDate;
	
	@NotNull(message="date cannot be empty")
	private Date endDate;



	@ManyToMany(cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
				joinColumns=@JoinColumn(name="project_id"), 
				inverseJoinColumns= @JoinColumn(name="employee_id")
	)
	@JsonIgnore
	private List<Employee> employees;
	
	public Project() {
		
	}


	public Project(String name, String stage, String description, List<Employee> employees,Date startDate, Date endDate) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
		this.employees = employees;
		this.startDate =startDate;
		this.endDate = endDate;
	}
	public Project(String name, String stage, String description,Date startDate, Date endDate) {
		super();
		this.name = name;
		this.stage = stage;
		this.description = description;
		this.startDate =startDate;
		this.endDate = endDate;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		
		stage = stage.toUpperCase();
		this.stage = stage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
//	//Convenience method
//	public void addEmployee(Employee emp) {
//		if(employees == null) {
//			employees= new ArrayList<> ();
//		}
//		employees.add(emp);
//		
//	}

}
