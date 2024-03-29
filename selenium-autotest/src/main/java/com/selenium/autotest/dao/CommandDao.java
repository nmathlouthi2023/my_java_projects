package com.selenium.autotest.dao;

import java.util.List;
import java.util.Map;

import com.selenium.autotest.entities.Command;

public interface CommandDao {

    public Command findById(Long id);

    public void remove(Long id);

    public Command add(Command command);

    public Command update(Long id, Command command);

    public List<Map<String, Object>> findAll();

    public List<Command> findCommands();
}
