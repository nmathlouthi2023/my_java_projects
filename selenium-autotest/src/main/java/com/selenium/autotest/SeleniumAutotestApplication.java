package com.selenium.autotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SeleniumAutotestApplication {
	public static final String FIREFOX_DRIVER_LOCATION = "C:/Documents/Development/Driver/geckodriver-v0.33.0-win64/geckodriver.exe";
	public static final String FIREFOX_DRIVER = "webdriver.gecko.driver"; //"webdriver.firefox.driver";

	public static void main(String[] args) {
		System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_LOCATION);
		SpringApplication.run(SeleniumAutotestApplication.class, args);
	}
}
