package ua.taskm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ua.taskm.entity.User;
import ua.taskm.service.MailSenderService;
import ua.taskm.service.TaskService;
import ua.taskm.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailSenderService mailSenderService;

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/newUser", method = RequestMethod.POST)
	public String saveuser(@RequestParam String name, @RequestParam String username, @RequestParam String email,
			@RequestParam String password) {

		String context = "Ти зареєструвався на сайті";
		String mailBody = "Вітаю на сайті " + "/nВаше імя";

		mailSenderService.sendMail(context, (new User(name, username, email, password)).getEmail(), mailBody);

		userService.save(new User(name, username, email, password));

		return "index";
	}

	@RequestMapping(value = "/loginproc", method = RequestMethod.GET)
	public String loginprocesing(Model model) {
		// model.addAttribute("userAuth",
		// userService.findOne(Integer.parseInt(principal.getName())));
		model.addAttribute("tasks", taskService.findAll());
		return "profile";
	}

	// @RequestMapping(value="/addtask", method=RequestMethod.POST)
	// public String addTask(Principal principal,@RequestParam String
	// description, @RequestParam String date){
	//
	//
	// User user = userService.findOne(Integer.parseInt(principal.getName()));
	//
	// taskService.save(new Task(description,date,user));
	// return "profile";
	// }
}
