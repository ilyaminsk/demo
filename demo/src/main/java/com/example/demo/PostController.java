package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	private SongRepo songRepo;

	PostController(PostService postService) {
	}


	@GetMapping("/")
	public ModelAndView printSongs() {
		ModelAndView mv = new ModelAndView();
		List<Song> songs = songRepo.findAll(); // Now using findAll() from SongRepository
		mv.addObject("songs", songs); // Add songs to the model
		mv.setViewName("index.html");
		return mv;
	}

	@GetMapping("calculator")

	public String calculator() {

		return "calculator.html";
	}

	@GetMapping("add")
	public ModelAndView ilya1(@RequestParam("t1") int i, @RequestParam("t2") int j) {

		int k = i + j;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("result.jsp");
		mv.addObject("result", k);
		return mv;

	};
	
	@PostMapping("/delete")
	public String delete (@RequestParam int id,RedirectAttributes redirectAttributes) {
		songRepo.delete(id);
		 redirectAttributes.addFlashAttribute("successMessage", "Your data has been processed successfully!");
	    
		return "redirect:/" ;
		
	}
	@PostMapping("/addSong")
	public String addSong (@RequestParam("ID") int ID, @RequestParam("songName") String Song, RedirectAttributes redirectAttributes) {	
		Song song= new Song();
		song.setSongID(ID);
		song.setName(Song);
		song.setStyle("Rock");
		song.setDuration(6);
		
		songRepo.save(song);
		 redirectAttributes.addFlashAttribute("successMessage", "Your data has been added successfully!");
	    
		return "redirect:/" ;
		
	}
	
}
