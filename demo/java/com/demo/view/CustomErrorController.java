package com.example.demo.view;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
public class CustomErrorController implements ErrorController {
	
	@GetMapping("error")
	public  ModelAndView error() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error1.html");	
		return mv;}
   
//    override this error path to custom error path
   public String  getErrorPath() {
    return "/custom-error";
   }

//   @GetMapping("/custom-error")
//   public String customHandling(HttpServletRequest request){
//	return null;
       // you can use request to get different error codes
       // request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)

       // you can return different `view` based on error codes.
       // return 'error-404' or 'error-500' based on errors
   }
