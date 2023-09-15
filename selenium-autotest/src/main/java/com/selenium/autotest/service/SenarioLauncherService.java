package com.selenium.autotest.service;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.selenium.autotest.entities.Command;

@Service
public class SenarioLauncherService implements ISenarioLauncherService {
    @SuppressWarnings("unused")
	private static final Logger LOG = LoggerFactory.getLogger(SenarioLauncherService.class);

    private WebDriver firefoxDriver = null;

    public SenarioLauncherService() {

    }

    private WebDriver getFirefoxDriver() {
        if (firefoxDriver == null) {
            firefoxDriver = new FirefoxDriver();
        }
        return firefoxDriver;
    }

    private void open(String url) {
        this.getFirefoxDriver().get(url);
    }

    private void navigateTo(String url) {
        this.getFirefoxDriver().navigate().to(url);
    }

    private void typeText(String selector, String text) {
        new Actions(this.getFirefoxDriver())
                .sendKeys(this.getFirefoxDriver().findElement(By.cssSelector(selector)), text)
                .perform();
    }

    private void clickAt(String selector) {
        this.getFirefoxDriver()
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
