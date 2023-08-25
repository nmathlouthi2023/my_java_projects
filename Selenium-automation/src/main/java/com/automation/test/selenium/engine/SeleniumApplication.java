package com.automation.test.selenium.engine;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.automation.test.selenium.launcher.SenarioLauncher;

@SpringBootApplication
@ComponentScan(basePackages={"com.automation.test.selenium"})
public class SeleniumApplication {

	public static final String FIREFOX_DRIVER_LOCATION = "C:/Documents/Development/Driver/geckodriver-v0.33.0-win64/geckodriver.exe";
	public static final String FIREFOX_DRIVER = "webdriver.firefox.driver";
	public static final String PORT = "8082";
	
	public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(SeleniumApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", PORT));
        app.run(args);
        
        System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_LOCATION);
        SenarioLauncher senarioLauncherService = new SenarioLauncher();
		senarioLauncherService.launchCommands();
    }
}
