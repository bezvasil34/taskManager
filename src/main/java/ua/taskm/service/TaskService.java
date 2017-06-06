package ua.taskm.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import ua.taskm.entity.Task;



public interface TaskService {

	
void save(Task task);
	
	List<Task> findAll();
	
	Task findOne(int id);
	
	void delete(int id);
	
	List<Task> allFetch();
	
	 void saveTaskImage(MultipartFile multipartFile,String id);
		void addTask(Principal principal,String description,  String date);
}
