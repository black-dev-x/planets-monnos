package com.monnos.planet;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends CrudRepository<Planet, String> {

	@Query("{ 'name': ?0.name, 'climate': ?0.climate, 'terrain': ?0.terrain }")
	Optional<Planet> findByNameAndClimateAndTerrain(Planet planet);

	@Query(" { 'name' : { $regex: ?0, $options: 'i'} }")
	List<Planet> findAllByName(String name);
}
