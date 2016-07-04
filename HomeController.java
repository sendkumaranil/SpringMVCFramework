package com.springmvcexample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcexample.model.Employee;
import com.springmvcexample.service.EmployeeService;
import com.springmvcexample.util.EmployeeException;
import com.springmvcexample.util.Utility;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	@Qualifier(value="employeeValidator")
	private Validator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	
	@RequestMapping({"/","/home"})
	public String showHomePage(Map<String,Object> employeeMap){
		
		List<Employee> empList=empService.getEmployee();
		employeeMap.put("employeelist", empList);
		return "home";
	}
	
	@RequestMapping(value="/profile/{employeeId}")
	public String viewProfilePage(Map<String,Object> employeeMap,@PathVariable int employeeId){
		Employee empProfile=empService.getEmployeeProfile(employeeId);
		employeeMap.put("emp_profile", empProfile);
		return "profile";
	}
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute @Validated Employee employee,BindingResult result) {
		
		if(result.hasErrors()){
			return new ModelAndView("addEmp");
		}
		empService.addEmployee(employee);
      return new ModelAndView("redirect:/");
   }

	@RequestMapping(value="/createEmpPage")
	public String showAddEmpPage(Model model){
		model.addAttribute("employee",new Employee());
		return "addEmp";
	}
	
	@RequestMapping(value="/profile/delete/{employeeId}",method=RequestMethod.GET)
	public ModelAndView deleteEmpAction(@PathVariable int employeeId){
		 empService.deleteEmployee(employeeId);
		 return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/profile/edit/{employeeId}",method=RequestMethod.GET)
	public String showEditEmpPage(@PathVariable int employeeId,Model model){
		Employee employee=empService.getEmployeeProfile(employeeId);
		model.addAttribute("employee",employee);
		return "editEmp";
	}
	
	@RequestMapping(value="/editEmployee",method=RequestMethod.POST)
	@ExceptionHandler(EmployeeException.class)
	public ModelAndView editEmployee(@ModelAttribute @Validated Employee employee,BindingResult result){
		
		if(!Utility.isValidEmail(employee.getEmailid())){
			throw new EmployeeException("Invalid Email id!!!");
		}
		
		if(!Utility.validatePhoneNumber(employee.getMobileno())){
			throw new EmployeeException("Invalid Mobile No[Only 10 digits allowed and no space and any chracters allowed!!]");
		}
		 empService.editEmployee(employee);
		 return new ModelAndView("redirect:/");
	}
	
}
