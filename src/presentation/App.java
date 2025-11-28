package presentation;

import java.util.Scanner;

import database.Task;
import database.ToDoList;
import operations.AddTask;
import operations.CompleteTask;
import operations.RemoveTask;

public class App {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        ToDoList todo = new ToDoList();
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

            switch(choice) {
                case 1:
                    System.out.print("Unesite opis zadatka: ");
                    String desc = sc.nextLine();
                    Task newTask = new Task(desc);
                    AddTask addTask = new AddTask();
                    addTask.addTaskToList(newTask, todo);
                    break;
                case 2:
                	PrintTasks print = new PrintTasks();
                	print.printTasks(todo);
                    break;
                case 3:
                    System.out.print("Unesite id zadatka za označavanje: ");
                    int doneIndex = sc.nextInt();
                    CompleteTask completeTask = new CompleteTask();
                    completeTask.completeTaskInListOfTasks(doneIndex, todo);
                    break;
                case 4:
                    System.out.print("Unesite id zadatka za brisanje: ");
                    RemoveTask remove = new RemoveTask();
                    int id = sc.nextInt();
                    remove.removeTaskFromTheList(id, todo);
                    break;
                case 0:
                    System.out.println("Izlaz iz programa...");
                    break;
                default:
                    System.out.println("Nepoznata opcija!");
            }
        } while(choice != 0);
        sc.close();
    }
}
