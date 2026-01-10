package controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Task;
import repository.ToDoList;

public class ListController {

	private static final Logger CONTROLLER_LOGGER = LogManager.getLogger(ListController.class);

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
			CONTROLLER_LOGGER.warn("TASK IS ALREADY COMPLETED!");
			throw new IllegalStateException("TASK IS ALREADY COMPLETED!");
		} else if (task.isEmpty()) {
			CONTROLLER_LOGGER.warn("TASK WITH ID " + id + " DOES NOT EXIST!");
			throw new IllegalArgumentException("TASK WITH ID " + id + " DOES NOT EXIST!");
		} else {

			task.get().markAsCompleted();

			CONTROLLER_LOGGER.info("TASK WITH ID " + id + " IS SET AS THE COMPLETED!");
		}
	}

	public void removeTaskFromTheList(String id, ToDoList toDoList) {

		Optional<Task> task = toDoList.getTasks().stream().filter(eachTask -> eachTask.getId().equals(id)).findFirst();

		if (task.isEmpty()) {

			CONTROLLER_LOGGER.warn("TASK WITH ID: " + id + " DOES NOT EXIST!");
			throw new IllegalStateException("TASK WITH ID: " + id + " DOES NOT EXIST!");

		} else {

			toDoList.getTasks().removeIf(eachTask -> eachTask.getId().equals(id));

			CONTROLLER_LOGGER.info("TASK WITH ID: " + id + " WAS SUCCESSFULLY REMOVED FROM THE LIST!");
		}

	}

	public void printTasks(ToDoList listToBePrinted) {

		CONTROLLER_LOGGER.info("LIST OF TASKS NAMED: " + listToBePrinted.getListName() + " PRINTS:");

		for (Task eachTask : listToBePrinted.getTasks()) {
			System.out.println(eachTask.toString());
		}
	}
}