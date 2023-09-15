package com.selenium.autotest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.selenium.autotest.entities.Command;
import com.selenium.autotest.service.ICommandService;
import com.selenium.autotest.service.ISenarioLauncherService;


@RestController
@CrossOrigin(origins ="*")
@RequestMapping(value = "/api/selenium/automation-test/commands")
public class CommandController {

	private static final Logger logger = LoggerFactory.getLogger(CommandController.class);
	
	private ICommandService commandService;
    private ISenarioLauncherService senarioLauncherService;

	@Autowired
    public CommandController(ICommandService commandService,
                             ISenarioLauncherService senarioLauncherService) {
        this.commandService = commandService;
        this.senarioLauncherService = senarioLauncherService;
    }
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public Command create(@RequestBody Command command) {
    	try {
        	return commandService.add(command);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Command update(@PathVariable("id") Long id, @RequestBody Command command) {
		try {
			return commandService.update(id, command);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	 
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Long delete(@PathVariable("id") Long id) {
        try {
        	commandService.remove(id);
        	return id;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value = "/liste", method = RequestMethod.GET, produces = "application/json")
    public List<Command> getAllCommands() {
        try {
        	List<Command> result = commandService.findCommands();
            return result;
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
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

    @RequestMapping(value = "/launch", method = RequestMethod.GET)
    public Long launch() {
    	try {
    		senarioLauncherService.launchCommands(commandService.findCommands());
    		return 1l;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw (e);
		}
        
    }
}
