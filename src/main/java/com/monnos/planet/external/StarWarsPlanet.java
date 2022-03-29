package com.monnos.planet.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monnos.planet.Planet;

@JsonIgnoreProperties(value = "id")
public class StarWarsPlanet extends Planet {

	private List<String> films;

	public void setFilms(List<String> films) {
		this.films = films;
	}

	public Integer getQuantityMovieAppearances() {
		return films.size();
	}

}
