package operations;


import database.Task;
import database.ToDoList;

public class AddTask {
	
	public void addTaskToList(Task taskToBeAdded, ToDoList toDoList) {
		//INFO - Demeter´s Law -> verstoßen!
		toDoList.getList().add(taskToBeAdded);
	}

}
