package com.monnos.planet.external;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StarWarsPlanetService {

	private final static String externalApiUrl = "https://swapi.dev/api/planets/?page=%d";
	
	@Cacheable
	public List<StarWarsPlanet> findAllPlanets(Integer pageNumber){
		RestTemplate restTemplate = new RestTemplate();
		StarWarsPlanetResponse result = restTemplate.getForObject(externalApiUrl.formatted(pageNumber), StarWarsPlanetResponse.class);
		return result.getResults();
	}
	
}
