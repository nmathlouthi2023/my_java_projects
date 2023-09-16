package com.selenium.autotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.selenium.autotest.util.ApplicationUtils;

@SpringBootApplication
public class SeleniumAutotestApplication {
	
	public static void main(String[] args) {
		System.setProperty(ApplicationUtils.FIREFOX_DRIVER, ApplicationUtils.FIREFOX_DRIVER_LOCATION);
		System.setProperty(ApplicationUtils.CHROME_DRIVER, ApplicationUtils.CHROME_DRIVER_LOCATION);
		SpringApplication.run(SeleniumAutotestApplication.class, args);
	}
}
