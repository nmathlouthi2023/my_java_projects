package com.selenium.autotest.repository;

import java.util.List;

import com.selenium.autotest.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface CommandRepository extends JpaRepository<Command, Long> {

	@Transactional(timeout = 10)
    Command findById(Long carId);
	
	@Transactional(timeout = 10)
	List<Command> findAll();
	
	/*@Transactional
	<S extends Command> S save(Command car);*/
	
	void delete(Command command);
}
