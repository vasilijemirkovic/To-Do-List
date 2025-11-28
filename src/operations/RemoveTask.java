package operations;

import database.ToDoList;

public class RemoveTask {
	
	public void removeTaskFromTheList(int id, ToDoList toDoList) {
		
		boolean removed = toDoList.getList().removeIf(task -> task.getId() == id);
	
		if (!removed) {
		    throw new IllegalArgumentException("THERE IS NO TASK WITH ID: " + id + " IN THIS LIST!");

		}
		
	}

}
