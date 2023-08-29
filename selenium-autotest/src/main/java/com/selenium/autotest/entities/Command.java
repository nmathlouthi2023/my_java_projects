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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="COMMAND")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Command implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final Logger logger = LoggerFactory.getLogger(Command.class);
	
	@Id
	@GeneratedValue(generator = "CMD_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "CMD_SEQ", sequenceName = "CMD_SEQ", allocationSize=1)
	@Column(name="CMD_ID", unique=true, nullable=false, precision=10, scale=0)
	@Getter @Setter
	private Long id;

	@Column(name = "CMD_NAME", nullable = true, length = 100)
	@Getter @Setter
	private String name;

	@Column(name = "CMD_LABEL", nullable = true, length = 100)
	@Getter @Setter
	private String label;

	@Column(name = "CMD_TARGET", nullable = true, length = 100)
	@Getter @Setter
	private String target;

	@Column(name = "CMD_VALUE", nullable = true, length = 300)
	@Getter @Setter
	private String value;
	
	public Command(){}

	public Command(String name, String label, String target, String value) {
		this.name = name;
		this.label = label;
		this.target = target;
		this.value = value;
	}
}
