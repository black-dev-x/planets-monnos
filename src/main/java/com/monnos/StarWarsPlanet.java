package com.monnos;

import java.util.List;

public class StarWarsPlanet extends Planet {

	private List<String> films;
	private Integer numberApparitionsMovie;

	public List<String> getFilms() {
		return films;
	}

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public Integer getNumberApparitionsMovie() {
		return numberApparitionsMovie;
	}

	public void setNumberApparitionsMovie(Integer numberApparitionsMovie) {
		this.numberApparitionsMovie = numberApparitionsMovie;
	}

}
