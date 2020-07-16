package ng.whycode.pma.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ng.whycode.pma.dao.IEmployeeRepository;
import ng.whycode.pma.entites.Employee;

public class UniqueValidator implements ConstraintValidator<UniqueValues, String> {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Employee emp = empRepo.findByEmail(value);
		System.out.println("Checking for unique values");
		if(emp != null)
			return false;
		else
			return true;
	}

	
}
