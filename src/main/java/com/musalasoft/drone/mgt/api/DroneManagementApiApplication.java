package com.musalasoft.drone.mgt.api;

import com.musalasoft.drone.mgt.api.dao.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class DroneManagementApiApplication implements CommandLineRunner {


	private final DroneRepository droneRepository;

	public static void main(String[] args) {
		SpringApplication.run(DroneManagementApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(droneRepository.count());
	}
}
