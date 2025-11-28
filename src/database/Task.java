package database;

import idGenerator.IdGenerator;

public class Task {
	
	private int id;
	private String description;
	private boolean taskCompleted;
	
	public Task() {
		this.id = 1000;
		this.description = "Default";
		this.taskCompleted = false;
	}
	
	public Task(String description){
		IdGenerator generator = new IdGenerator();
		this.id = generator.generateIdForTask();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	public boolean isTaskCompleted() {
		return taskCompleted;
	}
	
	public void setTaskAsCompleted() {
		this.taskCompleted = true;
	}
	
	//NOTE - pogledati kako ide equals
	public boolean equals(Task obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		String isCompleted = this.taskCompleted ? "COMPLETED" : "NOT COMPLETED";
		return "TASK WITH ID: " + this.id + ", AND description: " + this.description + " IS " + isCompleted + ".";
	}

}
