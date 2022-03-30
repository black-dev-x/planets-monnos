package com.monnos.planet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.monnos.exceptions.MissingPlanetAttributesException;
import com.monnos.exceptions.PlanetDuplicateException;

@SpringBootTest
class PlanetValidatorTest {

	@Autowired
	private PlanetValidator planetValidator;
	
	@MockBean
	private PlanetRepository planetRepository;
	
	@Test
	void contextIsLoaded() {
		assertThat(planetValidator).isNotNull();
	}

	@Test
	void throwsExceptionWhenPlanetNameIsEmpty() {
		assertThrows(MissingPlanetAttributesException.class, () -> {
			Planet planet =	buildPlanet(null, "test terrain", "test climate");
			planetValidator.validate(planet);
		});
	}
	
	@Test
	void throwsExceptionWhenTerrainIsEmpty() {
		assertThrows(MissingPlanetAttributesException.class, () -> {
			Planet planet =	buildPlanet("test name", "", "test climate");
			planetValidator.validate(planet);
		});
	}
	
	@Test
	void throwsExceptionWhenClimateIsEmpty() {
		assertThrows(MissingPlanetAttributesException.class, () -> {
			Planet planet =	buildPlanet("test name", "test terrain", "");
			planetValidator.validate(planet);
		});
	}
	@Test
	void throwsExceptionWhenSamePlanetWasCreatedBefore() {
		assertThrows(PlanetDuplicateException.class, () -> {
			Planet planet =	buildPlanet("test name", "test terrain", "test climate");
			Mockito.when(planetRepository.findByNameAndClimateAndTerrain(planet)).thenReturn(Optional.of(planet));
			planetValidator.validate(planet);
		});
	}
	
	private static Planet buildPlanet(String name, String terrain, String climate) {
		Planet planet = new Planet();
		planet.setName(name);
		planet.setTerrain(terrain);
		planet.setClimate(climate);
		return planet;
	}
}
