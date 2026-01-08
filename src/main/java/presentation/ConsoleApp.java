package presentation;

import java.util.Scanner;

import controller.ListController;
import model.Task;
import repository.ToDoList;

public class ConsoleApp {

	private Scanner sc;
	ToDoList todo;
	ListController controller;

	public ConsoleApp() {
		this.sc = new Scanner(System.in);
		this.todo = new ToDoList();
		this.controller = new ListController();
	}

	protected void executeConsoleApp() {

		int choice;

		do {
			System.out.println("\n--- To-Do Lista ---");
			System.out.println("1. Dodaj zadatak");
			System.out.println("2. Prikazi zadatke");
			System.out.println("3. Označi zadatak kao završen");
			System.out.println("4. Obriši zadatak");
			System.out.println("0. Izlaz");
			System.out.print("Izaberite opciju: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Unesite opis zadatka: ");
				String desc = sc.nextLine();
				Task newTask = new Task(desc);
				controller.addTaskToList(newTask, todo);
				break;
			case 2:
				controller.getTasks(todo).forEach(System.out::println);
				break;
			case 3:
				System.out.print("Unesite id zadatka koji je uspjesno zavrsen: ");
				String doneIndex = sc.nextLine();
				controller.completeTaskInListOfTasks(doneIndex, todo);
				break;
			case 4:
				System.out.print("Unesite id zadatka za brisanje: ");
				String id = sc.nextLine();
				controller.removeTaskFromTheList(id, todo);
				break;
			case 0:
				System.out.println("Izlaz iz programa...");
				break;
			default:
				System.out.println("Nepoznata opcija!");
			}
		} while (choice != 0);
		sc.close();
	}

}
