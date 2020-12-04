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

import com.bankapp.model.dao.Account;
import com.bankapp.model.service.AccountService;

@Controller
public class AccountController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping("addaccount")
	public String addAccountGet(ModelMap map) {
		map.addAttribute("addAccount", new Account());
		return "addaccount";
	}
	
	@PostMapping("addaccount")
	public String addUserPost(@Valid @ModelAttribute("addAccount") Account addAccount, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("error");
			return "addaccount";
		} else {
			if(addAccount.getAccountId() == 0) {
				System.out.println(addAccount);
				accountService.addAccount(addAccount);
			} else {
				accountService.updateAccount(addAccount);
			}
			
		return "redirect:/showallaccounts";
		}
	}
	
	@GetMapping("updateaccount")
	public String updateUserGet(ModelMap map, HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Account account = accountService.getAccountById(id);
		map.addAttribute("addAccountBean", account);
		return "updateaccount";
	}
	
	@GetMapping("deleteaccount")
	public String deleteAccount( HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		accountService.delAccount(id);
		return "redirect:/showallaccounts";
	}
	
	@GetMapping("showallaccounts")
	public ModelAndView showAllusers(ModelAndView mv) {
		List<Account> accounts = accountService.getAllAccounts();
		mv.addObject("allaccounts", accounts);
		mv.setViewName("showallaccounts");
		return mv;
	}
}