package model;

import generator.IdGenerator;

public class Task {

	private final String id;
	private String description;
	private boolean taskCompleted;
	private IdGenerator generator = new IdGenerator();

	public Task() {
		this.id = generator.generateTaskId();
		this.description = "Default";
		this.taskCompleted = false;
	}

	public Task(String description) {
		this.id = generator.generateTaskId();
		this.description = description;
	}

	public String getId() {
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
		if (this == o) {
			return true;
		}
		if (!(o instanceof Task)) {
			return false;
		}
		Task other = (Task) o;
		return this.id == other.id;
	}

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
