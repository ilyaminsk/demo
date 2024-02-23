package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;

public class MusicListBuilder {

	public RockMusic music;

	public ClassicMusic clMusic;

	public MusicListBuilder(@Qualifier("classicMusic") ClassicMusic clMusic, @Qualifier("rockMusic") RockMusic music) {

		this.music = music;
		this.clMusic = clMusic;
	}

	public List<String> buildPlaylistRock() {

		List<String> musicList = new ArrayList<>(Arrays.asList(music.getNames()));
		return musicList;

	}

	public List<String> buildPlaylistClassic() {

		List<String> musicList = new ArrayList<>(Arrays.asList(clMusic.getNames()));
		return musicList;

	}

}
