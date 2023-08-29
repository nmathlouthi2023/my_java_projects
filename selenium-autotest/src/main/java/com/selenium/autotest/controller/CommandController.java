package com.selenium.autotest.controller;

import com.selenium.autotest.entities.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.selenium.autotest.service.CommandService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/selenium/automation-test")
public class CommandController {

	private static final Logger logger = LoggerFactory.getLogger(CommandController.class);
	
	CommandService commandService;

	@Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }
	
	@RequestMapping(value = "/commands", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Command command) {
        try {
        	logger.info(command.getName());
        	logger.info(command.getLabel());
        	logger.info(command.getTarget());
        	logger.info(command.getValue());
            commandService.add(command);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "/commands", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAllCommands() {
        try {
        	List<Map<String, Object>> result = commandService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/commands/{id}", method = RequestMethod.GET)
    public ResponseEntity<Command> getCommandById(@PathVariable("id") Long id) {
        try {
            Command command = commandService.findById(id);
            if (command != null) {
                return ResponseEntity.status(HttpStatus.OK).body(command);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	@RequestMapping(value = "/commands/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody Command command) {
        try {
            commandService.update(id, command);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/commands/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        try {
            commandService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
