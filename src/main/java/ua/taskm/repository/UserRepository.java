package ua.taskm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.taskm.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
    User findByEmail(String email);
	
	 @Query(value = "select u from User u left join fetch u.tasks t where u.id =:id")
	    User findfetchUser(@Param("id") int id);
	 

}
