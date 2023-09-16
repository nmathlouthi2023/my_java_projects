package com.selenium.autotest.service;

import com.selenium.autotest.entities.Command;

import java.util.List;
import java.util.Map;

public interface ICommandService {
    public Command findById(Long id);

    public void remove(Long id);

    public List<Map<String, Object>> findAll();

    public List<Command> findCommands();

    public Command add(Command command);

    public Command update(Long id, Command command);
}
