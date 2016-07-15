package com.springmvcexample.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcexample.model.Employee;
import com.springmvcexample.model.Role;
import com.springmvcexample.model.User;
import com.springmvcexample.model.UserRoleMapping;
import com.springmvcexample.service.UserService;

@Controller
public class RoleController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/usermanage/registerRole")
	public String showRegisterUserPage(Model model){
		model.addAttribute("role",new Role());
		return "registerRole";
	}
	
	@RequestMapping(value = "/usermanage/addRole", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute Role role,BindingResult result) {
	
	  userService.addRole(role);
      return new ModelAndView("redirect:/usermanage/register");
	}
	
	@RequestMapping("/usermanage/userRoleMapping")
	public String showUserRoleMapping(Map<String,Object> employeeMap,Model model){
		
		List<User> userList=userService.getUsers();
		List<Role> roleList=userService.getRoles();
		List<UserRoleMapping> mappedUsers=userService.getMappedUsers();
		
		employeeMap.put("userlist", userList);
		employeeMap.put("rolelist", roleList);
		employeeMap.put("mappedUsers",mappedUsers);
		
		model.addAttribute("userRoleMap",new UserRoleMapping());
		return "mappingUserRole";
	}
	
	@RequestMapping("/usermanage/processMapping")
	public ModelAndView assignRoleToUser(@ModelAttribute UserRoleMapping userRoleMap,BindingResult result){
		userService.userRoleMapping(userRoleMap);
		return new ModelAndView("redirect:/usermanage/userRoleMapping");
	}
	
	@RequestMapping("/usermanage/removeMappedUsers")
	public @ResponseBody String removeMapping(@ModelAttribute UserRoleMapping userRoleMap,BindingResult result){
		
		userService.removeMappedUsers(userRoleMap);
	    return "/SpringMVCExample/usermanage/userRoleMapping";
	}
}
