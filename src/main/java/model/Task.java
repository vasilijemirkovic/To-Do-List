package model;

import java.util.Objects;

import generator.IdGenerator;

public class Task {

	private final String id;
	private String description;
	private boolean completed;
	private IdGenerator generator = new IdGenerator();

	public Task(String description) {
		this.id = generator.generateTaskId();
		this.description = Objects.requireNonNull(description);
		this.completed = false;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = Objects.requireNonNull(description);
	}

	public boolean isCompleted() {
		return completed;
	}

	public void markAsCompleted() {
		this.completed = true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Task)) {
			return false;
		}
		Task task = (Task) o;
		return id.equals(task.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return String.format("Task[id=%s, description=%s, status=%s]", id, description,
				completed ? "COMPLETED" : "OPEN");
	}
}
