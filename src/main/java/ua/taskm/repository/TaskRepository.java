package ua.taskm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ua.taskm.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>  {

	
	@Query("select distinct t from Task t")
	List<Task> findAllByFetch();
}
