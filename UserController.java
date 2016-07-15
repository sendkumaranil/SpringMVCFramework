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
import org.springframework.web.servlet.ModelAndView;

import com.springmvcexample.model.User;
import com.springmvcexample.model.UserRoleMapping;
import com.springmvcexample.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/usermanage/register")
	public String goToRegisterPage(){
		return "register";
	}
	
	@RequestMapping(value="/usermanage/registerUser")
	public String showRegisterUserPage(Model model){
		model.addAttribute("user",new User());
		return "registerUser";
	}
	
	@RequestMapping(value = "/usermanage/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute User user,BindingResult result) {
	
		userService.addUser(user);
      return new ModelAndView("redirect:/usermanage/register");
	}
	
	@RequestMapping(value="/forgetPassword")
	public String showForgetPassword(Model model){
		model.addAttribute("user",new User());
		return "resetPassword";
	}
	
	@RequestMapping("/resetPassword")
	public ModelAndView resetPassword(@ModelAttribute User user,BindingResult result){
		ModelAndView mv=new ModelAndView();
		boolean isSuccess= userService.isValidUser(user);
		if(!isSuccess){
			mv.addObject("errmsg","Invalid UserName!!");
			mv.setViewName("forgetPassword");
			return mv;
		}
		 String status=userService.resetPassword(user);
		 if("success".equalsIgnoreCase(status)){
			 mv.setViewName("redirect:/resetPasswordSuccess");
		 }else{
			 mv.addObject("errmsg","Password reset failed!!");
			 mv.setViewName("forgetPassword");
		 }
		
		 return mv;
	}
	
	@RequestMapping("/resetPasswordSuccess")
	public String resetPasswordSuccess(Model model){
		model.addAttribute("msg","Your Password has been reset successfully and mail sent to your registered email!!");
		return "resetPasswordSuccess";
	}
	
	@RequestMapping("/changePwd")
	public ModelAndView changePassword(@ModelAttribute User user,BindingResult result){
		ModelAndView mv=new ModelAndView();
		boolean isSuccess= userService.isValidUser(user);
		if(!isSuccess){
			mv.addObject("errmsg","Invalid UserName!!");
			mv.setViewName("changePassword");
			return mv;
		}
		userService.changePassword(user);
		mv.setViewName("redirect:/welcome");
		return mv;
	}
	
	@RequestMapping(value="/changePassword")
	public String showChangePassword(Model model){
		model.addAttribute("user",new User());
		return "changePassword";
	}
	
	@RequestMapping("/viewUsersAndRoles")
	public String viewUserAndRoles(Map<String,Object> usersRoleMap){
		List<UserRoleMapping> usersAndRolesList=userService.getMappedUsers();
		usersRoleMap.put("mappedUsers", usersAndRolesList);
		return "viewUsersAndRoles";
	}
}
