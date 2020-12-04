package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bankapp.model.dao.Login;
import com.bankapp.model.dao.User;
import com.bankapp.model.service.UserService;

@Controller
public class LoginController {

	private UserService userService;
	
	@Autowired
	public LoginController(UserService userService)
	{
		this.userService=userService;
	}

	@GetMapping("/")
	public String Home() {
		return "allservices";
	}
	
	

		
	
	@GetMapping("login")
	public String LoginGet(ModelMap mv) {
		//Login login = new Login();
		mv.put("loginForm", new Login());
		return "login";
	}
	
	@PostMapping("login")
		public String loginPost(@Valid @ModelAttribute("loginpage") Login login, BindingResult result, HttpServletRequest req) {
			
			if(result.hasErrors()) {
				return "login";
			} else {
				HttpSession session = req.getSession();
				String username = login.getUsername();
				String password = login.getPassword();
				
				if(userService.isUserExist(username)) {
					User user = userService.getUser(username);
				
					if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
						session.setAttribute("user", user);
						System.out.println(session.getAttribute("user"));
						return "redirect:/Home";
					} else {
						req.setAttribute("message", "Invalid username or password");
						return "login";
					}
				} else {
					req.setAttribute("message", "No account for the provided username and password");
					return "login";
				}
			}
	
	}
	}
