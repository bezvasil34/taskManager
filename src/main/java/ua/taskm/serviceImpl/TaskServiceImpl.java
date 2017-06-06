package ua.taskm.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import ua.taskm.entity.Task;
import ua.taskm.entity.User;
import ua.taskm.repository.TaskRepository;
import ua.taskm.repository.UserRepository;
import ua.taskm.service.TaskService;
import ua.taskm.service.UserService;

@Service
public class TaskServiceImpl implements  TaskService{
	
	
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UserRepository userRepository;

	public void save(Task task) {
		taskRepository.save(task);
		
	}

	public List<Task> findAll() {
		
		return taskRepository.findAll();
	}

	public Task findOne(int id) {
		
		return taskRepository.findOne(id);
	}

	public void delete(int id) {
		taskRepository.delete(id);
		
	}

	public List<Task> allFetch() {
		
		return taskRepository.findAllByFetch();
	}

	public void saveTaskImage(MultipartFile multipartFile, String taskId) {
		
 Task task = taskRepository.findOne(Integer.parseInt(taskId));
		 
		 String path = System.getProperty("catalina.home")+"/resources/"
	                + task.getId() + "/" +multipartFile.getOriginalFilename();
		 
		 task.setTaskPathImage("resources/"+task.getId()+ "/" + multipartFile.getOriginalFilename());

	        File file = new File(path);
	        
	        try {
	            file.mkdirs();
	           
	            try {
	                FileUtils.cleanDirectory
	                        (new File(System.getProperty("catalina.home")+"/resources/" + task.getId() + "/"));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home")+"/resources/" + task.getId()+ "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	            multipartFile.transferTo(file);
	        } catch (IOException e) {
	            System.out.println("error with file");
	        }
	        taskRepository.save(task);
		 
		
	}

	@Override
	@Transactional
	public void addTask(Principal principal, String description, String date) {
		User  user =  userRepository.findfetchUser(Integer.parseInt(principal.getName()));
		Task task = new Task(description, date);
		user.getTasks().add(task);
		userRepository.save(user);
		
		
	}



}
