package ua.taskm.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.taskm.entity.User;

public interface UserService {

void save(User user);
	
	List<User> findAll();
	
	User findOne(int id);
	
	void delete(int id);
	
	 User findUserFetch(int id);
	 
	 void saveImage(Principal principal, MultipartFile multipartFile);
	 
	    User findByUsername(String username);

	    User findByEmail(String email);
}
