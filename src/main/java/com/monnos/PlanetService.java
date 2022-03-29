package com.monnos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;
	
	public List<Planet> findAllPlanets() {
		return planetRepository.findAll();
	}
	
	public Planet createPlanet(Planet planet) {
		return planetRepository.save(planet);
	}

}
