package com.homebudgetmanager.plannedexpensesservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PlannedExpensesServiceApplication implements CommandLineRunner {
	@Autowired
	private Data data;

	public static void main(String[] args) {
		SpringApplication.run(PlannedExpensesServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//data.deleteRep();
		data.populate();
	}
}
