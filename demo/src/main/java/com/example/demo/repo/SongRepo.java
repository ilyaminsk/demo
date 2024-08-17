	package com.example.demo.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.demo.model.Song;
@Component
public class SongRepo {
	@Autowired
	private static JdbcTemplate template;

	public SongRepo(JdbcTemplate template) {
		SongRepo.template = template;
	}
	
	public void  test() {
		System.out.println("fff");
	};

	public void save(Song song) {
		String sql = "insert into song (name,style,duration) values (?,?,?)";
		template.update(sql, song.getName(), song.getStyle(), song.getDuration());
	}
	
	public void delete(int id) {
		String sql ="DELETE FROM song WHERE songID = ?";
		template.update(sql, id);
	}

	public   List<Song> findAll() {

		String sql = "select * from song";

		RowMapper<Song> rowMapper = new RowMapper<Song>() {

			@Override
			public Song mapRow(ResultSet rs, int rowNum) throws SQLException {

				Song s = new Song();
				s.setSongID(rs.getInt(1));
				s.setName(rs.getString("Name"));
				s.setStyle(rs.getString("Style"));
				s.setDuration(rs.getInt("duration"));
				return s;
			}
		};

		List<Song> song = template.query(sql, rowMapper);
		return song;
	}
	
}
