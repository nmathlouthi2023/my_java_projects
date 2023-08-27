package com.selenium.autotest.engine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.selenium.autotest"})
public class SeleniumEngineApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SeleniumEngineApplication.class);
		application.run(args);
	}
}
