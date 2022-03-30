package com.monnos.planet;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PlanetServiceTest {

	@Autowired
	private PlanetService planetService;
	
	@Test
	void contextIsLoaded() {
		assertThat(planetService).isNotNull();
	}

}
