package ua.taskm.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;


import javax.persistence.JoinColumn;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;

	@Lob
	private String description;
	
	private String taskPathImage;
	private  String date;
	
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "task_user",
	            joinColumns = @JoinColumn(name = "id_user"),
	            inverseJoinColumns = @JoinColumn(name = "id_task"))
	    private List<User> users;
	 
	 public Task() {
		
	}

	
	public Task(String description, String date) {
		super();
		this.description = description;
		this.date = date;
	}




	public Task(String description, String date, List<User> users) {
		super();
		this.description = description;
		this.date = date;
		this.users = users;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public String getTaskPathImage() {
		return taskPathImage;
	}

	public void setTaskPathImage(String taskPathImage) {
		this.taskPathImage = taskPathImage;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Task [description=" + description + ", date=" + date + ", users=" + users + "]";
	}
	 
	
	 
	 
}
