package repository;

import java.util.ArrayList;
import java.util.List;

import model.Task;

public class ToDoList {

	private String listName;
	private final List<Task> list;

	public ToDoList() {
		this.listName = "Default";
		this.list = new ArrayList<Task>();
	}

	public ToDoList(String listName, List<Task> list) {
		this.listName = listName;
		this.list = list;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public List<Task> getList() {
		return list;
	}
}
