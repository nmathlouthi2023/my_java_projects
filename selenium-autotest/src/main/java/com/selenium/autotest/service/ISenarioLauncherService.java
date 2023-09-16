package com.selenium.autotest.service;

import com.selenium.autotest.entities.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public interface ISenarioLauncherService {
    public void launchCommands(List<Command> commands);
    public String getBrowser();
    public void setBrowser(String browser);
    public void initBrowser();
}
