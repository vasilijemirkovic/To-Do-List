package database;

import idGenerator.IdGenerator;

public class Task {
	
	//TODO: NotNull & Unique
	private final int id;
	private String description;
	private boolean taskCompleted;
	private IdGenerator generator = new IdGenerator();

	
	public Task() {
		this.id = 1000;
		this.description = "Default";
		this.taskCompleted = false;
	}
	
	public Task(String description){
		this.id = generator.generateIdForTask();
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
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
	
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Task)) return false;
	    Task other = (Task) o;
	    return this.id == other.id;
	}
	
	//TODO: provjeriti valja li hashCode metoda
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public String toString() {
		String isCompleted = this.taskCompleted ? "COMPLETED" : "NOT COMPLETED";
		return "TASK WITH ID: " + this.id + ", AND description: " + this.description + " IS " + isCompleted + ".";
	}

}
