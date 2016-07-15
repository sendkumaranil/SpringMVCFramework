package com.springmvcexample.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvcexample.model.Employee;

public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> param) {
		
		return Employee.class.equals(param);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "empname", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mobileno", "phone.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "dob.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "doj", "doj.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idtype", "idtype.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idno", "idno.required");
		
		Employee employee=(Employee)obj;
		if(!Utility.isValidEmail(employee.getEmailid())){
			errors.rejectValue("emailid","invalidEmail",new Object[]{"emailid"},"Invalid emailid!!");
		}
		if(!Utility.validatePhoneNumber(employee.getMobileno())){
			errors.rejectValue("mobileno","invalidmobileno",new Object[]{"mobileno"},"Invalid mobile No [only 10 digits allowed and no space and others characters allowed]");
		}
		if(employee.getDeptid()==-1){
			errors.rejectValue("deptid","emptydepartment",new Object[]{"deptid"},"Please select department");
		}
	}
}
