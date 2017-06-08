package ua.taskm.controller;

import java.security.Principal;

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

		return "loginpage";
	}

	@RequestMapping(value = "/loginprocesing", method = RequestMethod.GET)
	public String loginprocesing(Model model, Principal principal) {
	
		model.addAttribute("tasks", taskService.findAll());
		return "profile";
	}


}
