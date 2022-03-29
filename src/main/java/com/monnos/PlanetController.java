package com.monnos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetController {
 
	@Autowired
	private PlanetService planetService;
	
	@GetMapping("/planets")
	public List<Planet> findAllPlanets(){
		return planetService.findAllPlanets();
	}
	
	@PostMapping("/planets")
	public Planet createPlanet(@RequestBody Planet planet) {
		return planetService.createPlanet(planet);
	}
}
