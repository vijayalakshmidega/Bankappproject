package com.bankapp.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.User;
import com.bankapp.model.service.UserService;

@Controller
public class UserController {


private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("adduser")
	public String addUserGet(ModelMap map) {
		map.addAttribute("user", new User());
		return "adduser";
	}
	
	@PostMapping("adduser")
	public String addUserPost(@Valid @ModelAttribute("adduser") User user, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("error");
			return "adduser";
		} else {
			if(user.getUid() == 0) {
				userService.addUser(user);
			} else {
				userService.updateUser(user, user.getUid());
			}
			
		return "redirect:/showallusers";
		}
	}
	
	@GetMapping("updateuser")
	public String updateUserGet(ModelMap map, HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("id"));
		User user = userService.getUserById(uid);
		map.addAttribute("userBean", user);
		System.out.println(user);
		return "updateuser";
	}
	
	@GetMapping("deleteuser")
	public String deleteAccount( HttpServletRequest request) {
		Integer uid = Integer.parseInt(request.getParameter("id"));
		userService.delUser(uid);
		return "redirect:/showallusers";
	}
	
	@GetMapping("showallusers")
	public ModelAndView showAllusers(ModelAndView mv) {
		List<User> users = userService.getAllUsers();
		mv.addObject("allusers", users);
		mv.setViewName("showallusers");
		return mv;
	}
	
	
//	@ModelAttribute(value = "usertypes")
//	public UserType[] userType() {
//		return UserType.values();
//	}
}
