package com.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.dao.DataIntegrityViolationException;
import com.exception.*;


// Global exception handler
@ControllerAdvice
public class ExceptionAdvice {
	
    @ResponseStatus(value=HttpStatus.CONFLICT, reason="Data integrity violation")  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void conflict() {
    	// Nothing to do
    }
	
//    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No Account Exists")  // 404
//    @ExceptionHandler(NoAccountException.class)
//    public void notFound() {
//    	
//    }
//    
	 @ExceptionHandler(Exception.class)
	  public ModelAndView handleError(HttpServletRequest req, Exception ex) {
	  
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("exception", ex);
	    mav.addObject("url", req.getRequestURL());
	    mav.setViewName("ErrorPage");
	    return mav;
	  }
}
