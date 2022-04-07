package com.example.accessingdatamysql;


public class TaskNotFoundException extends Exception{

	private long task_id;
	public TaskNotFoundException(long task_id) {
	        super(String.format("Task is not found with id : '%s'", task_id));
	        }
	
}
