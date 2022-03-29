package com.monnos.planet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monnos.planet.external.StarWarsPlanet;
import com.monnos.planet.external.StarWarsPlanetService;

@RestController
public class PlanetController {

	@Autowired
	private PlanetService planetService;

	@Autowired
	private StarWarsPlanetService starWarsService;

	@GetMapping("/planets")
	public List<Planet> findAllPlanets(@RequestParam(defaultValue = "") String name) {
		return planetService.findAllPlanets(name);
	}

	@GetMapping("/planets/{id}")
	public Planet findPlanetById(@PathVariable("id") String id) {
		return planetService.findById(id);
	}

	@PostMapping("/planets")
	public Planet createPlanet(@RequestBody Planet planet) {
		return planetService.createPlanet(planet);
	}

	@DeleteMapping("/planets/{id}")
	public void deletePlanet(@PathVariable("id") String id) {
		planetService.deletePlanet(id);
	}

	@GetMapping("/external/planets")
	public List<StarWarsPlanet> findPlanetsFromStarWarsApi(@RequestParam(defaultValue = "1") Integer pageNumber) {
		return starWarsService.findAllPlanets(pageNumber);
	}
}
