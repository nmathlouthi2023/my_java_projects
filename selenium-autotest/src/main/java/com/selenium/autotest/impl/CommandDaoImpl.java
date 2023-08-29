package com.selenium.autotest.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.selenium.autotest.dao.CommandDao;
import com.selenium.autotest.entities.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.selenium.autotest.repository.CommandRepository;

@Repository
public class CommandDaoImpl implements CommandDao {

	private static final Logger logger = LoggerFactory.getLogger(CommandDaoImpl.class);
	
	@Autowired
	private CommandRepository commandRepository;
	
    public CommandDaoImpl() {
    	
    }

    @Override
    public Command findById(Long id) {
    	
    	try {
            return commandRepository.findById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

    @Override
    public void remove(Long id) {
    	try {
    		Command command = new Command();
    		command.setId(id);
    		commandRepository.delete(command);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void add(Command command) {
    	try {
    		commandRepository.save(command);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void update(Long id, Command command) {
    	try {
    		command.setId(id);
    		commandRepository.save(command);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public List<Map<String, Object>> findAll() {
    	try {
    		List<Map<String, Object>> list = new ArrayList<>();
        	Map<String, Object> map = new HashMap<>();
        	List<Command> result = commandRepository.findAll();
            for (Command command : result) {
            	map = new HashMap<>();
            	map.put(command.getId().toString(), command);
            	list.add(map);
            }
            return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

}
