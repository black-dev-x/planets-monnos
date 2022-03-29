package com.monnos.planet;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monnos.exceptions.PlanetNotFoundException;

@Service
public class PlanetService {

	@Autowired
	private PlanetRepository planetRepository;

	@Autowired
	private PlanetValidator planetValidator;

	public List<Planet> findAllPlanets(String name) {
		return planetRepository.findAllByName(name);
	}

	public Planet createPlanet(Planet planet) {
		planetValidator.validate(planet);
		return planetRepository.save(planet);
	}

	public void deletePlanet(String id) {
		planetRepository.deleteById(id);
	}

	public Planet findById(String id) {
		Optional<Planet> planet = planetRepository.findById(id);
		return planet.orElseThrow(() -> new PlanetNotFoundException());
	}

}
