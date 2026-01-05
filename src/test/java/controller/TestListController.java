package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import model.Task;
import repository.ToDoList;

public class TestListController {

	ListController listController;
	ToDoList todo;

	@BeforeEach
	void setup() {
		listController = new ListController();
		todo = new ToDoList();
	}

	static Stream<Task> tasks() {
		return Stream.of(new Task("Clean the room"), new Task("Finish homework"), new Task("Exercise"),
				new Task("Code a project"));
	}

	@ParameterizedTest
	@MethodSource("tasks")
	void addTaskToListPositiveTest(Task task) {
		ToDoList todo = new ToDoList();
		ListController controller = new ListController();

		controller.addTaskToList(task, todo);

		assertEquals(1, todo.getList().size());
		assertTrue(todo.getList().contains(task));
	}

	@Test
	void taskIsCompletedNowPositiveTest() {
		Task task = new Task("Completed task");
		todo.getList().add(task);
		listController.completeTaskInListOfTasks(task.getId(), todo);

		assertTrue(task.isTaskCompleted());
	}

	@Test
	void taskWasAlreadyCompletedPositiveTest() {
		Task task = new Task("Completed task");

		task.setTaskAsCompleted();

		todo.getList().add(task);

		listController.completeTaskInListOfTasks(task.getId(), todo);

		assertTrue(task.isTaskCompleted());
	}

	@Test
	void completeTaskInListNegativeTest() {
		Task task = new Task("Some task");
		todo.getList().add(task);

		String nonExistingId = "99999";

		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> listController.completeTaskInListOfTasks(nonExistingId, todo));

		assertTrue(ex.getMessage().equals("Task with id: 99999 does not exist."));
	}

	@Test
	void successfullyRemovedTaskPositiveTest() {
		Task task = new Task("Completed task");
		todo.getList().add(task);
		listController.removeTaskFromTheList(task.getId(), todo);

		assertFalse(todo.getList().contains(task));
	}

	@Test
	void removeTaskFromTheListNegativeTest() {
		Task task = new Task("Some task");
		todo.getList().add(task);

		String nonExistingId = "99999";

		IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
				() -> listController.removeTaskFromTheList(nonExistingId, todo));

		assertTrue(ex.getMessage().equals("THERE IS NO TASK WITH ID: 99999 IN THIS LIST!"));
	}

	@Test
	void printTasksPositiveTest() {

		// arrange
		Logger mockLogger = Mockito.mock(Logger.class);
		ListController controller = new ListController();
		Mockito.when(mockLogger.isLoggable(Mockito.any())).thenReturn(true);
		// controller.setLogger(mockLogger);

		ToDoList list = new ToDoList();
		list.setListName("My Tasks");
		list.getList().add(new Task("Task 1"));
		list.getList().add(new Task("Task 2"));

		// act
		controller.printTasks(list);

		// assert
		Mockito.verify(mockLogger).info("LIST OF TASKS NAMED: My Tasks PRINTS:");
	}

}
