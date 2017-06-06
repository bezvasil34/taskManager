package ua.taskm.service;

public interface MailSenderService {

	void sendMail(String context, String email, String mailBody);

}
