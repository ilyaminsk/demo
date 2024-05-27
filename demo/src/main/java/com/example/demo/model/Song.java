package com.example.demo.model;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Song {
	String songID;
	String Name;
	String Style;
	int Duration;
	enum Rating  {good,bad,netural};
	Rating rating;
	
	public String getSongID() {
		return songID;
	}
	public void setSongID(String iD) {
		this.songID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getStyle() {
		return Style;
	}
	public void setStyle(String style) {
		Style = style;
	}
	public int getDuration() {
		return Duration;
	}
	public void setDuration(int duration) {
		Duration = duration;
	}
	@Override
	public String toString() {
		return '\n'+ "Song [songID=" + songID + ", Name=" + Name + ", Style=" + Style + ", Duration=" + Duration + ", rating="
				+ rating + "]" ;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	

}
