package com.automation.test.selenium.launcher;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.stereotype.Component;

import com.automation.test.selenium.model.Command;
import com.automation.test.selenium.model.ICommand;
import com.automation.test.selenium.util.ConstantsUtil;

@Component
public class SenarioLauncher {

	public static final String LOGIN = "methlouthi.nebyl@gmail.com";
	public static final String PASSWORD = "Nabil22343556";
	public static final String[] URLS = { 
			"https://github.com/",
			"https://github.com/login"
	};
	
	WebDriver firefoxDriver = new FirefoxDriver();

	private void open(String url) {
		firefoxDriver.get(url);
	}

	private void navigateTo(String url) {
		firefoxDriver.navigate().to(url);
	}
	
	private void typeText(String selector, String text) {
		new Actions(firefoxDriver)
			.sendKeys(firefoxDriver.findElement(By.cssSelector(selector)), text)
			.perform();
	}

	private void clickAt(String selector) {
		firefoxDriver
			.findElement(By.cssSelector(selector))
			.click();
	}

	public void launchCommands() {
		
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(new Command("open", URLS[0]));
		commands.add(new Command("clickAt", "a[href='/login']"));
		commands.add(new Command("navigateTo", URLS[1]));
		commands.add(new Command("typeText", "input[id='login_field']", LOGIN));
		commands.add(new Command("typeText", "input[id='password']", PASSWORD));
		commands.add(new Command("clickAt", "input[name='commit']"));
		
		for (ICommand c : commands) {
			if ("open".equals(c.getCmd())) {
				open(c.getTarget());
			} else
			if ("clickAt".equals(c.getCmd())) {
				clickAt(c.getTarget());
			} else
			if ("navigateTo".equals(c.getCmd())) {
				navigateTo(c.getTarget());
			} else
			if ("typeText".equals(c.getCmd())) {
				typeText(c.getTarget(), c.getValue());
			}
		}
		
	}
	
	public void launch() {

		open(URLS[0]);

		clickAt("a[href='/login']");
		
		navigateTo(URLS[1]);

		typeText("input[id='login_field']", LOGIN);
		
		typeText("input[id='password']", PASSWORD);
		
		clickAt("input[name='commit']");
		
	}
	//JavascriptExecutor js = (JavascriptExecutor)firefoxDriver;
	//js.executeScript("alert('Welcome to Packt Publishing!');");

}
