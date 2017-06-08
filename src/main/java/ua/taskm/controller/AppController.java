package ua.taskm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.taskm.service.TaskService;
import ua.taskm.service.UserService;

@Controller
public class AppController {

	@Autowired
	private UserService userService;

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "loginpage";
	}
		@RequestMapping(value = "/profile", method = RequestMethod.GET)
		public String prof(Model model) {
				model.addAttribute("tasks", taskService.findAll());
			return "profile";
	}
		
		@RequestMapping(value = "/edit/prof", method = RequestMethod.GET)
		public String profi(Model model) {
				model.addAttribute("tasks", taskService.findAll());
			return "redirect:/profile";
	}
		
		@RequestMapping(value = "/addtask/prof", method = RequestMethod.GET)
		public String addtaskprof(Model model) {
				model.addAttribute("tasks", taskService.findAll());
			return "redirect:/profile";
	}
}
