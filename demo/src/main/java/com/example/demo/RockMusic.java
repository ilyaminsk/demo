package com.example.demo;

import java.util.Random;


public class RockMusic implements Music {

	enum ID {
		Rock, Classic
	};

	public ID[] id = { ID.Rock, ID.Rock, ID.Rock, ID.Rock };

	public String[] name = { "Wind of change", "We will rock you", "Hotel California", "Hello" };

	public String[] getNames() {
		return name;
	}

	public void setName(String[] name) {
		this.name = name;
	}

	String[] Length = { "2 minutes", "5 min", "5min", "6 min" };

	@Override
	public String getSongName() {

		Random random = new Random();

		return name[random.nextInt(name.length)];

	}

	public Music setMusic() {

		return new RockMusic();
	}

	@Override
	public Music returnSong() {

		return new RockMusic();
	}

	@Override
	public void setNames() {
		// TODO Auto-generated method stub

	}
}
