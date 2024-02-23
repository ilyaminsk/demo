package com.example.demo;


import java.util.Random;

import org.springframework.stereotype.Component;

@Component

public class ClassicMusic implements Music {

	String[] names = { "Chaikovski", "Bethhoven", "Vivaldi", "shubert" };
	String[] Length = { "3 min", "4 min", "5 min", "6 min" };

	@Override
	public String getSongName() {
		Random random = new Random();

		return names[random.nextInt(names.length)];
	}

	public Music returnSong() {

		return new ClassicMusic();
	}

	@Override
	public String[] getNames() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public void setNames() {
		// TODO Auto-generated method stub

	}
}