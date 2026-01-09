package controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import model.Task;
import repository.ToDoList;

public class ListController {

	private static final Logger CONTROLLER_LOGGER = Logger.getLogger(ListController.class.getName());

	public void addTaskToList(Task taskToBeAdded, ToDoList toDoList) {

		List<Task> listOfTasks = toDoList.getTasks();

		listOfTasks.add(taskToBeAdded);
	}

	public List<Task> getTasks(ToDoList todo) {
		return todo.getTasks();
	}

	public void completeTaskInListOfTasks(String id, ToDoList listOfTasks) {

		Optional<Task> task = listOfTasks.getTasks().stream().filter(eachTask -> eachTask.getId().equals(id))
				.findFirst();

		if (task.isPresent() && task.get().isCompleted()) {
			CONTROLLER_LOGGER.warning("TASK IS ALREADY COMPLETED!");
		} else {
			listOfTasks.getTasks().stream().filter(eachTask -> eachTask.getId().equals(id)).findAny()
					.orElseThrow(() -> new IllegalArgumentException("Task with id: " + id + " does not exist."))
					.markAsCompleted();

			CONTROLLER_LOGGER.info("TASK WITH ID " + id + " IS SET AS THE COMPLETED!");
		}
	}

	public void removeTaskFromTheList(String id, ToDoList toDoList) {

		boolean removed = toDoList.getTasks().removeIf(task -> task.getId().equals(id));

		if (!removed) {
			CONTROLLER_LOGGER.severe("THERE IS NO TASK WITH ID: " + id + " IN THIS LIST!");
			throw new IllegalArgumentException("THERE IS NO TASK WITH ID: " + id + " IN THIS LIST!");
		}

		CONTROLLER_LOGGER.info("TASK WITH ID: " + id + " WAS SUCCESSFULLY REMOVED FROM THE LIST!");

	}

	public void printTasks(ToDoList listToBePrinted) {

		CONTROLLER_LOGGER.info("LIST OF TASKS NAMED: " + listToBePrinted.getListName() + " PRINTS:");

		for (Task eachTask : listToBePrinted.getTasks()) {
			System.out.println(eachTask.toString());
		}
	}
}