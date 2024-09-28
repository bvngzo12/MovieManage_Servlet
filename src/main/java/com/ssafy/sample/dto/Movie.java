package com.ssafy.sample.dto;

public class Movie {
	private String code;
	private String title;
	private int time;
	private String director;
	private String genre;
	
	public Movie() {
		
	}
	
	public Movie(String code, String title, int time, String director, String genre) {
		super();
		this.code = code;
		this.title = title;
		this.time = time;
		this.director = director;
		this.genre = genre;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "MovieDto [code=" + code + ", title=" + title + ", time=" + time + ", director=" + director + ", genre="
				+ genre + "]";
	}
	
	
	
	
}
