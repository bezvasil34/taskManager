package ua.taskm.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.taskm.entity.Task;
import ua.taskm.entity.User;
import ua.taskm.service.TaskService;
import ua.taskm.service.UserService;

@Controller
public class TaskController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TaskService taskService;
	
	
	@RequestMapping(value="/addtaskpage", method=RequestMethod.GET)
	public String addTaskPage(){
		
	
				return "addtask";
		
	}
	
//	@RequestMapping(value="/addtask", method=RequestMethod.POST)
//	public String addTask( @RequestParam String description, @RequestParam String date ){
//		
//	taskService.save(new Task(description,date));
//	
//				return "redirect:/profile";
//	
//	}
	
	@RequestMapping(value="/addtask", method=RequestMethod.POST)
	public String adddTask(Principal principal,@RequestParam String description, @RequestParam String date){
taskService.addTask(principal, description, date);
	
				return "redirect:/profile";
}
	
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
		public String delTask(@PathVariable String id){
			taskService.delete(Integer.parseInt(id));
			return "redirect:/profile";
	 }
	 
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
		public String editTask(@PathVariable String id){
			
			return "edit";
	 }
	
}
