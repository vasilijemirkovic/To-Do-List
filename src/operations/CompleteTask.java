package operations;

import database.Task;
import database.ToDoList;

public class CompleteTask {
	
	public void completeTask(Task task) {
		task.setTaskAsCompleted();
		System.out.println(task.toString());
	}
	
	public void completeTaskInListOfTasks(int id, ToDoList listOfTasks) {
		
		listOfTasks.getList().stream()
	    .filter(eachTask -> eachTask.getId() == id)
	    .findAny()
	    .orElseThrow(() -> new IllegalArgumentException(
	            "Task with id: " + id + " does not exist."))
	    .setTaskAsCompleted();
		
		
		//TODO: baca logger.info da je setovan na zavrsen
		//TODO: baca logger.info da je vec zavrsen zadatak
	}
}
