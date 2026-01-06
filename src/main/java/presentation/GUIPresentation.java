package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.ListController;
import model.Task;
import repository.ToDoList;

public class GUIPresentation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ToDoList todo;
	private ListController controller;

	private JTextField taskInput;
	private JTextArea taskArea;
	private JTextField taskIdInput;

	public GUIPresentation() {
		todo = new ToDoList();
		controller = new ListController();

		setTitle("To-Do Lista");
		setSize(500, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		initUI();
	}

	private void initUI() {
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		add(mainPanel);

		// ===== TOP PANEL (Unos zadatka) =====
		JPanel topPanel = new JPanel(new BorderLayout(5, 5));
		taskInput = new JTextField();
		JButton addButton = new JButton("Dodaj zadatak");

		topPanel.add(taskInput, BorderLayout.CENTER);
		topPanel.add(addButton, BorderLayout.EAST);

		// ===== CENTER PANEL (Prikaz zadataka) =====
		taskArea = new JTextArea();
		taskArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(taskArea);

		// ===== BOTTOM PANEL (Akcije) =====
		JPanel bottomPanel = new JPanel(new GridLayout(2, 2, 5, 5));

		taskIdInput = new JTextField();

		JButton showButton = new JButton("Prikaži zadatke");
		JButton completeButton = new JButton("Završi zadatak");
		JButton deleteButton = new JButton("Obriši zadatak");

		bottomPanel.add(new JLabel("ID zadatka:"));
		bottomPanel.add(taskIdInput);
		bottomPanel.add(completeButton);
		bottomPanel.add(deleteButton);

		// ===== ADD PANELS =====
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(showButton, BorderLayout.SOUTH);
		mainPanel.add(bottomPanel, BorderLayout.EAST);

		// ===== ACTIONS =====
		addButton.addActionListener(e -> addTask());
		showButton.addActionListener(e -> refreshTasks());
		completeButton.addActionListener(e -> completeTask());
		deleteButton.addActionListener(e -> deleteTask());
	}

	private void addTask() {
		String desc = taskInput.getText();
		if (desc.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Unesite opis zadatka!");
			return;
		}
		controller.addTaskToList(new Task(desc), todo);
		taskInput.setText("");
		refreshTasks();
	}

	private void refreshTasks() {
		taskArea.setText("");
		controller.getTasks(todo).forEach(task -> taskArea.append(task.toString() + "\n"));
	}

	private void completeTask() {
		String id = taskIdInput.getText();
		controller.completeTaskInListOfTasks(id, todo);
		refreshTasks();
	}

	private void deleteTask() {
		String id = taskIdInput.getText();
		controller.removeTaskFromTheList(id, todo);
		refreshTasks();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new GUIPresentation().setVisible(true));
	}
}
