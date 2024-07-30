package com.example.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Song;
import com.example.demo.repo.SongRepo;


@PropertySource(value = "classpath:additional.properties")
@Controller
@RequestMapping
public class PostController {
	
	private LocalDateTime postedOn;
	 @Value("${email.password}")
	private String check;
	 @Value("${testValue}")
	private String testValue;
	 @Autowired
	 SongRepo songRepo;
	 
	 
	PostController(PostService postService) {}
	
	void check () {
	ArrayList<Song> list = (ArrayList<Song>) songRepo.findAll();
	for (Song listSong: list) 
	{
System.out.println(listSong.getName());
}
	}
//	@GetMapping("/")
//	public ModelAndView printSongs(SongRepo songRepo ) {
//		ModelAndView mv = new ModelAndView(); 
//	//	ArrayList<Song> list = (ArrayList<Song>) songRepo.findAll();
//		mv.setViewName("index.html");
//		return mv;	
		
	
	
	@GetMapping("calculator")
	
	public String calculator() {
		
		return "calculator.html";
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
