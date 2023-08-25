package com.automation.test.selenium.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Command implements ICommand{

	private Long id;
	private String cmd;
	private String target;
	private String value;
	
	public Command(String cmd, String target) {
		super();
		this.cmd = cmd;
		this.target = target;
	}

	public Command(String cmd, String target, String value) {
		super();
		this.cmd = cmd;
		this.target = target;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public String getCmd() {
		return cmd;
	}

	public String getTarget() {
		return target;
	}

	public String getValue() {
		return value;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
