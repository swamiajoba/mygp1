package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.dao.DataIntegrityViolationException;

import com.bean.Account;
import com.exception.NoAccountException;
import com.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping("showallaccount")
	public String showAllAcc(Model m)
	{
		System.out.println("Listing all accounts");
		List<Account> alist=accountService.getAccountList();
		m.addAttribute("alist", alist);
		return "ListAllAcounts";
	}
	
	// Adding new Account
	@RequestMapping("accform")
		public String getAccForm(Model m)
		{
			m.addAttribute("acc", new Account());
			return "AccForm";
		}
	
	   @RequestMapping(value="/save",method = RequestMethod.POST)    
	    public String save(@Valid @ModelAttribute("acc") Account acc , BindingResult result){   
		   	if(result.hasErrors()) {
		   		return "AccForm";
		   	}
		   
	        accountService.saveAccount(acc)    ;
	        return "redirect:/showallaccount";//will redirect to viewemp request mapping    
	    }
	   
	   /* It displays object data into form for the given id.   
	     * The @PathVariable puts URL data into variable.*/    
	    @RequestMapping(value="/editacc/{id}")    
	    public String edit(@PathVariable("id") int id, Model m) throws NoAccountException{    
	    	System.out.println("Before edit form");
	        Account ac=accountService.getAccountById(id);    
	        m.addAttribute("acc",ac);  
	        return "AccEditForm";   
	    }    
	    
	    /* It updates model object. */    
	    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
	    public String editsave(@Valid @ModelAttribute("acc") Account acc , BindingResult result){    
	     	if(result.hasErrors()) {
		   		return "AccEditForm";
		   	}
	     	else {
	     		System.out.println("Update in controller");
	     		System.out.println(acc);
	     		accountService.updateAccount(acc);
	     		return "redirect:/showallaccount";   
	     	}
	    }    
	    
	    /* It deletes record for the given id in URL and redirects to /viewemp */    
	    @RequestMapping(value="/deleteacc/{id}",method = RequestMethod.GET)    
	    public String delete(@PathVariable int id) throws NoAccountException{
	    	Account ac= accountService.getAccountById(id);
	        accountService.deleteAccount(ac);
	        return "redirect:/showallaccount";    
	    }     
	    
	    @GetMapping("searchmyaccount")
	    public String searchmyaccount() {
	    	return "SearchAccount";
	    }
	    
	    @PostMapping("searchbyid")
	    public String searchAccount(@RequestParam("searchacc") int aid , Model model) throws NoAccountException {
	    	Account ac= accountService.getAccountById(aid);
	    	model.addAttribute("myacc",ac);
	    	return "DisplayAccount";
	    	
	    }
	    
	    //Local exception handler
//	    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
//	    @ExceptionHandler(DataIntegrityViolationException.class)
//	    public void conflict() {
//	    	// Nothing to do
//	    }
}
