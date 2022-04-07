package com.example.accessingdatamysql;

public class UserstoryNotFoundException extends Exception{

	private long userstory_id;
	public UserstoryNotFoundException(long userstory_id) {
	        super(String.format("UserStory is not found with id : '%s'", userstory_id));
	        }
}
