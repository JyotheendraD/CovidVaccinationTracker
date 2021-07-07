package io.covidVaccinationTracker.covidvaccinationTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidVaccinationTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidVaccinationTrackerApplication.class, args);
	}

}
