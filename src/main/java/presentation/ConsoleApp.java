package presentation;

import java.util.Scanner;

import controller.ListController;
import model.Task;
import repository.ToDoList;

public class ConsoleApp {

	private Scanner sc;
	private ToDoList todo;
	private ListController controller;

	public ConsoleApp() {
		this.sc = new Scanner(System.in);
		this.todo = new ToDoList();
		this.controller = new ListController();
	}

	protected void executeConsoleApp() {

		int choice;

		do {
			// TODO: TASK: Add input validation for menu choice
			// TODO: TASK: Change loggers in other classes
			System.out.println("\n--- To-Do List ---");
			System.out.println("1. Add task");
			System.out.println("2. Show tasks");
			System.out.println("3. Mark task as completed");
			System.out.println("4. Delete task");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter task description: ");
				String desc = sc.nextLine();
				Task newTask = new Task(desc);
				controller.addTaskToList(newTask, todo);
				break;
			case 2:
				// TODO: TASK: No logic in the presentation layer
				if (controller.getTasks(todo).isEmpty()) {
					System.out.println("No tasks available.");
					break;
				}
				controller.getTasks(todo).forEach(System.out::println);
				break;
			case 3:

				System.out.print("Enter the ID of the completed task: ");
				String doneIndex = sc.nextLine();

				try {
					controller.completeTaskInListOfTasks(doneIndex, todo);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:

				System.out.print("Enter the ID of the task for deleting: ");
				String id = sc.nextLine();

				try {
					controller.removeTaskFromTheList(id, todo);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 0:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Unknown option. Please try again.");
			}
		} while (choice != 0);
		sc.close();
	}

}
