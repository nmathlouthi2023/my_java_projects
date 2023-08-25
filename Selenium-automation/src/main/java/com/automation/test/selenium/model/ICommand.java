package com.automation.test.selenium.model;


public interface ICommand {

	public Long getId();
	public String getCmd();
	public String getTarget();
	public String getValue();
	
	public void setId(Long id);
	public void setCmd(String cmd);
	public void setTarget(String target);
	public void setValue(String value);
	
}
