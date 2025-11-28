package presentation;


import database.Task;
import database.ToDoList;

public class PrintTasks {
	
	public void printTasks(ToDoList listToBePrinted) {
		System.out.println("LIST OF TASKS NAMED: " + listToBePrinted.getListName() + " PRINTS: ");
		for(Task eachTask: listToBePrinted.getList()) {
			System.out.println(eachTask.toString());
		}
		
	}

}
