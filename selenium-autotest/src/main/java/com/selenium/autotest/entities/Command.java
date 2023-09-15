package com.selenium.autotest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.Getter;
//import lombok.Setter;

@Entity
@Table(name="COMMAND")
@JsonIgnoreProperties(ignoreUnknown=true)
//@Getter
//@Setter
public class Command implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(Command.class);
	
	@Id
	@GeneratedValue(generator = "CMD_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CMD_SEQ", sequenceName = "CMD_SEQ", allocationSize=1)
	@Column(name="CMD_ID", unique=true, nullable=false)
	private Long id;

	@Column(name = "CMD_NAME", nullable = true, length = 100)
	private String name;

	@Column(name = "CMD_LABEL", nullable = true, length = 100)
	private String label;

	@Column(name = "CMD_TARGET", nullable = true, length = 100)
	private String target;

	@Column(name = "CMD_VALUE", nullable = true, length = 300)
	private String value;
	
	@Column(name = "CMD_ORDER", nullable = true, length = 20)
	private Long order;
	
	public Command(){}

	public Command(String name, String label, String target, String value) {
		this.name = name;
		this.label = label;
		this.target = target;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}
	
	
	
}
