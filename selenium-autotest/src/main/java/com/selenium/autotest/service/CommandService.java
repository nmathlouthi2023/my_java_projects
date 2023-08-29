package com.selenium.autotest.service;

import java.util.List;
import java.util.Map;

import com.selenium.autotest.entities.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.selenium.autotest.dao.CommandDao;

@Service
@Transactional
public class CommandService {

	@Autowired
    private CommandDao carDao;

    public CommandService() {
    	
    }

    public Command findById(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0");
        }
        return carDao.findById(id);
    }

    public void remove(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
        }
        carDao.remove(id);
    }

    public List<Map<String, Object>> findAll() {

        List<Map<String, Object>> result = carDao.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    public void add(Command command) {
        if (command == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        carDao.add(command);
    }

    public void update(Long id, Command command) {
        if (id <= 0 && command == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        carDao.update(id, command);
    }

}
