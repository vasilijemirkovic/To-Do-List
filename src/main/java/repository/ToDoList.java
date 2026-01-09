package repository;

import java.util.ArrayList;
import java.util.List;

import model.Task;

public class ToDoList {

	private final String listName; // final
	private List<Task> tasks = new ArrayList<>();

	public ToDoList() {
		this.listName = "Default List";
	}

	public ToDoList(String listName) {
		this.listName = listName;
	}

	public String getListName() {
		return listName;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void add(Task task) {
		tasks.add(task);
	}

	public void remove(Task task) {
		tasks.remove(task);
	}
}
