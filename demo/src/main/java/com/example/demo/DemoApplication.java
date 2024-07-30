package com.example.demo;



import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Song;
import com.example.demo.repo.SongRepo;





@SpringBootApplication
@Controller


public class DemoApplication extends  SpringBootServletInitializer {
		
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) { 
	        return builder.sources(DemoApplication.class);}
	    
	public static org.springframework.context.ApplicationContext applicationContext;

	
	public static void main(String[] args) {

		applicationContext = SpringApplication.run(DemoApplication.class, args);

		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}

		
		Song song= applicationContext.getBean(Song.class);
		MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
		song.setName("Yulia playing ");
		song.setStyle("Rock");
		song.setDuration(6);

		SongRepo songRepo = applicationContext.getBean(SongRepo.class);

		System.out.println(song);

		songRepo.save(song);
		ArrayList<Song> list = (ArrayList<Song>) songRepo.findAll();
		
		for (Song listSong: list) 
				{
			System.out.println(listSong.getName());
		}

		PostController post = new PostController(null);
		post.check();
		
		
	//	musicPlayer.playMusicList(ID.Rock);
	}

	 
}
