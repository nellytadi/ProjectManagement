package ng.whycode.pma.entites;

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
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import ng.whycode.pma.validation.UniqueValues;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
	private long employeeId;
	
	@NotNull
	@Size(min=2,max=50)
	private String fullName;
	
	@NotNull
	@Email
	@UniqueValues
	private String email;
	
	@NotNull
	private int age;

	@ManyToMany(cascade =  {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
			   fetch = FetchType.LAZY)
	@JoinTable(name="project_employee",
	joinColumns=@JoinColumn(name="employee_id"),
	inverseJoinColumns= @JoinColumn(name="project_id")
			)
	@JsonIgnore
	private List<Project> projects;
	
	public Employee() {
		
	}
	public Employee(String fullName, String email,int age) {
		super();
	
		this.fullName = fullName;
		this.email = email;
		this.age = age;
	}
	
	public Employee(String fullName, String email,int age, List<Project> projects) {
		super();
	
		this.fullName = fullName;
		this.email = email;
		this.age = age;
		this.projects = projects;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	

	
}
