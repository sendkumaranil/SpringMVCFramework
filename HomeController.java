package com.springmvcexample.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcexample.model.Department;
import com.springmvcexample.model.Employee;
import com.springmvcexample.model.User;
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
	
	@RequestMapping("/welcome")
	public String showWelcomePage(Map<String,Object> employeeMap){
		
		List<Employee> empList=empService.getEmployee();
		employeeMap.put("employeelist", empList);
		return "welcome";
	}
	
	@RequestMapping({"/","/home"})
	public String showHomePage(){
		return "home";
	}
	
	@RequestMapping(value="/login")
    public String login(HttpServletRequest request, @RequestParam(value = "error", required = false) String error,Model model){
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}
        return "login";
    }
	
	@RequestMapping(value="/logout")
    public String logut(HttpServletRequest request, Model model){
        return "home";
    }
	
	@RequestMapping(value="/accessDenied")
	public String accessDenied(){
		return "denied";
	}
	
	@RequestMapping(value="/contact")
	public String contactUs(){
		return "contact";
	}
	
	@RequestMapping(value="/profile/{employeeId}")
	public String viewProfilePage(Map<String,Object> employeeMap,@PathVariable int employeeId){
		Employee empProfile=empService.getEmployeeProfile(employeeId);
		employeeMap.put("emp_profile", empProfile);
		return "profile";
	}
	
	@RequestMapping(value = "/manageEmp/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@ModelAttribute @Validated Employee employee,BindingResult result) {
		
		if(result.hasErrors()){
			return new ModelAndView("addEmp");
		}
		empService.addEmployee(employee);
      return new ModelAndView("redirect:/");
   }

	@RequestMapping(value="/manageEmp/createEmpPage")
	public String showAddEmpPage(Map<String,Object> empMap,Model model){
		List<Department> deptList=empService.getDepartments();
		empMap.put("deptList",deptList );
		model.addAttribute("employee",new Employee());
		return "addEmp";
	}
	
	@RequestMapping(value="/manageEmp/profile/delete/{employeeId}",method=RequestMethod.GET)
	public ModelAndView deleteEmpAction(@PathVariable int employeeId){
		 empService.deleteEmployee(employeeId);
		 return new ModelAndView("redirect:/welcome");
	}
	
	@RequestMapping(value="/manageEmp/profile/edit/{employeeId}",method=RequestMethod.GET)
	public String showEditEmpPage(@PathVariable int employeeId,Model model){
		Employee employee=empService.getEmployeeProfile(employeeId);
		List<Department> deptList=empService.getDepartments();
		model.addAttribute("deptList", deptList);
		model.addAttribute("employee",employee);
		return "editEmp";
	}
	
	@RequestMapping(value="/manageEmp/editEmployee",method=RequestMethod.POST)
	@ExceptionHandler(EmployeeException.class)
	public ModelAndView editEmployee(@ModelAttribute @Validated Employee employee,BindingResult result){
		ModelAndView mv=new ModelAndView();
		
		if(result.hasErrors()){
			List<Department> deptList=empService.getDepartments();
			mv.addObject("deptList", deptList);
			mv.setViewName("editEmp");
			return mv;
		}
		
		if(!Utility.isValidEmail(employee.getEmailid())){
			throw new EmployeeException("Invalid Email id!!!");
		}
		
		if(!Utility.validatePhoneNumber(employee.getMobileno())){
			throw new EmployeeException("Invalid Mobile No[Only 10 digits allowed and no space and any chracters allowed!!]");
		}
		
		 empService.editEmployee(employee);
		 mv.setViewName("redirect:/welcome");
		 return mv;
	}
	
	@RequestMapping("/aboutus")
	public String showAboutUs(){
		
		return "aboutus";
	}
}
