package com.selenium.autotest.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.selenium.autotest.entities.Command;
import com.selenium.autotest.util.ApplicationUtils;

@Service
public class SenarioLauncherService implements ISenarioLauncherService {
    @SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SenarioLauncherService.class);

    private WebDriver driver = null;
    private String browser = null;

    public SenarioLauncherService() {

    }

    public String getBrowser() {
    	return this.browser;
    }
    
    public void setBrowser(String browser) {
    	this.browser = browser;
    }
    
    public void initBrowser() {
    	driver = null;
    }
    
    private WebDriver getDriver() {
        if (driver == null) {
        	if (browser != null && browser.equals(ApplicationUtils.CHROME_BROWSER_KEY)) {
        		ChromeOptions ops = new ChromeOptions();
            	ops.addArguments("--remote-allow-origins=*");
            	driver = new ChromeDriver(ops);
        	} else {
        		driver = new FirefoxDriver();
        	}
        }
        return driver;
    }

    private void open(String url) {
        this.getDriver().get(url);
    }

    private void navigateTo(String url) {
        this.getDriver().navigate().to(url);
    }

    private void typeText(String selector, String text) {
        new Actions(this.getDriver())
                .sendKeys(this.getDriver().findElement(By.cssSelector(selector)), text)
                .perform();
    }

    private void clickAt(String selector) {
        this.getDriver()
                .findElement(By.cssSelector(selector))
                .click();
    }

    public void launchCommands(List<Command> commands) {
    	for (Command c : commands) {
            if ("open".equals(c.getName())) {
                open(c.getTarget());
            } else
            if ("clickAt".equals(c.getName())) {
                clickAt(c.getTarget());
            } else
            if ("navigateTo".equals(c.getName())) {
                navigateTo(c.getTarget());
            } else
            if ("typeText".equals(c.getName())) {
                typeText(c.getTarget(), c.getValue());
            }
        }
    }
}
