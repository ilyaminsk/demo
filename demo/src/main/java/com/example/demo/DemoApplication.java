package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.MusicPlayer.ID;
import com.example.demo.model.Song;
import com.example.demo.repo.SongRepo;

@SpringBootApplication

public class DemoApplication {
	public static org.springframework.context.ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(DemoApplication.class, args);

		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}

		Song song = applicationContext.getBean(Song.class);
		MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
		song.setName("Yulia playing ");
		song.setStyle("Rock");
		song.setDuration(6);

		SongRepo songRepo = applicationContext.getBean(SongRepo.class);

		System.out.println(song);

		songRepo.save(song);

		System.out.println(songRepo.findAll());

		musicPlayer.playMusicList(ID.Rock);
	}
}
