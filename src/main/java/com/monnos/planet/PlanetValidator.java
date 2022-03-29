package com.monnos.planet;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.monnos.exceptions.MissingPlanetAttributesException;
import com.monnos.exceptions.PlanetDuplicateException;

@Component
public class PlanetValidator {

	@Autowired
	private PlanetRepository planetRepository;

	public void validate(Planet planet) {
		attributesValidation(planet);
		databaseValidation(planet);
	}

	private void databaseValidation(Planet planet) {
		Optional<Planet> copy = planetRepository.findByNameAndClimateAndTerrain(planet);
		boolean alreadySaved = copy.isPresent();
		if (alreadySaved) {
			throw new PlanetDuplicateException();
		}
	}

	private void attributesValidation(Planet planet) {
		boolean lacksAName = planet.getName() == null || planet.getName().isBlank();
		boolean lacksClimate = planet.getClimate() == null || planet.getClimate().isBlank();
		boolean lacksTerrain = planet.getTerrain() == null || planet.getTerrain().isBlank();
		if (lacksAName || lacksClimate || lacksTerrain) {
			throw new MissingPlanetAttributesException();
		}
	}
}
