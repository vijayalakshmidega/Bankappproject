package com.bankapp.web.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.webbeans.DepositBeans;
import com.bankapp.webbeans.TransferBeans;
import com.bankapp.webbeans.WithdrawBeans;


@Controller
public class AccountMgtController {
	
	private AccountService accountService;
	private TransactionLogService transactionService;
	@Autowired
	public AccountMgtController(AccountService accountService,TransactionLogService transactionService) {
		this.accountService = accountService;
		this.transactionService = transactionService;

		
		
	}
	
	
	@GetMapping("/allservices")
	public String Services() {
		return "allservices";
	}

	@GetMapping("/transfer")
	public String AccountsTransferGet(ModelMap map) {
		map.addAttribute("transfer", new TransferBeans());
		return "transfer";
		
	}
	
	@PostMapping("/transfer")
	public String AccountsTransfer(@ModelAttribute(name="transferbeans") TransferBeans transferbean) {
		
		int fromaccountId=transferbean.getFromAccountId();
		int toaccountId=transferbean.getToAccountId();
		double amount=transferbean.getAmount();
        accountService.transferMoney(fromaccountId, toaccountId, amount);
        return "redirect:/Services";
	}
	
	@GetMapping("/deposit")
	public String AccountDepositGet(ModelMap map) {
		map.addAttribute("deposit", new DepositBeans());
		return "deposit";
		
	}
	
	@PostMapping("/deposit")
	public String AccountDepositPost(@ModelAttribute(name="depositbeans") DepositBeans depositbean) {
		int deaccountId=depositbean.getDeAccountId();
		Account accountde=accountService.getAccountById(deaccountId);
		double deAmount=depositbean.getDeAmount();
		accountService.depositMoney(deaccountId, deAmount);
		accountService.updateAccount(accountde);
		return "redirect:/Services";
	}
	
	@GetMapping("/withdraw")
	public String AccountWithdrawGet(ModelMap map) {
		map.addAttribute("withdraw", new WithdrawBeans());
		return "withdraw";
	}
	
	@PostMapping("/withdraw")
	public String AccountWithdrawPost(@ModelAttribute(name="withdrawbeans") WithdrawBeans withdrawbeans) {
		int wdaccounId=withdrawbeans.getWdAccountId();
		Account accountwd=accountService.getAccountById(wdaccounId);
	    double wdAmount=withdrawbeans.getWdAmount();
		accountService.withdrawMoney(wdaccounId, wdAmount);
		accountService.updateAccount(accountwd);
		return "redirect:/Services";
	
	}
	
	@GetMapping("getalltransactions")
	public ModelAndView transactionsHistory(HttpServletRequest request, ModelAndView mv) {
		int accountId = Integer.parseInt(request.getParameter("id"));
		System.out.println("transaction id--------------------------------------------- "+ accountId);
		List<TransactionLog> transactionHistory = transactionService.getTransactionLogFromAnAccount(accountId);
		mv.setViewName("gettransactions");
		mv.addObject("transactionHistory", transactionHistory);
		return mv;
	}
}
