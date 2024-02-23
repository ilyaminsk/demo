package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@PropertySource(value = "classpath:additional.properties")
@Controller
@RequestMapping
public class PostController {

	 @Value("${email.password}")
	private String check;
	 @Value("${testValue}")
	private String testValue;
	private final PostService postService1;

	PostController(PostService postService) {
		this.postService1 = postService;
	};


	@GetMapping("/")
	public String findAll() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index.jsp");
//		System.out.println(check);
//		System.out.println(testValue);
//		return mv;
		return("index.jsp");
	}

	@GetMapping("add")
	public ModelAndView ilya1(@RequestParam("t1") int i,@RequestParam("t2") int j ) {

		int k = i + j;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", k);
		return mv;

	}
}
