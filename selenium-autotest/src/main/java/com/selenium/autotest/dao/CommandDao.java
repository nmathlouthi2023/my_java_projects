package com.selenium.autotest.dao;

import java.util.List;
import java.util.Map;

import com.selenium.autotest.entities.Command;

public interface CommandDao {

    public Command findById(Long id);

    public void remove(Long id);

    public void add(Command command);

    public void update(Long id, Command command);

    public List<Map<String, Object>> findAll();
}
