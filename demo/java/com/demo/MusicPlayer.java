package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.Priority;



public class MusicPlayer {

	public enum ID {
		Rock, Classic
	};

	private ID id;

	RockMusic rockMusic;

	ClassicMusic classicMusic;

	MusicListBuilder mb;

	public MusicPlayer(  ClassicMusic classicMusic,RockMusic rockMusic ,MusicListBuilder mb) {
 
		this.rockMusic = rockMusic;
		this.classicMusic = classicMusic;
		this.mb = mb;

	}

	org.springframework.context.ApplicationContext applicationContext;

// 	public String toString(){
// 		return "ID is  "+id ;
// 	}

	void setMussicId(ID id) {
		this.id = id;
	}

	public void playMusic() {

		System.out.println("Playing single song from :    " + rockMusic.getSongName() + classicMusic.getSongName());

	}

	public void playMusicList(ID id) {

		System.out.println(id);

		if (id == ID.Rock) {
			List<String> musicList = mb.buildPlaylistRock();

			for (String ml : musicList)

			{
				System.out.println("Playing list:    " + ml);
			}
		}

		if (id == ID.Classic) {

			List<String> musicList = mb.buildPlaylistClassic();

			for (String ml : musicList)

			{
				System.out.println("Playing list:    " + ml);
			}
		}
	}

}
