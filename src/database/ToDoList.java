package database;

import java.util.List;
import java.util.ArrayList;


public class ToDoList {
	
	private String listName;
	private List<Task> list;
	
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

	public void setList(List<Task> list) {
		this.list = list;
	}

}
