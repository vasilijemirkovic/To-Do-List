package presentation;

import javax.swing.SwingUtilities;

import presentation.presentationMode.EPresentationMode;

public class App {

	public static void main(String[] args) {

		EPresentationMode mode = EPresentationMode.CONSOLE;

		switch (mode) {
		case CONSOLE -> {
			ConsoleApp consoleApp = new ConsoleApp();
			consoleApp.executeConsoleApp();
		}
		case GUI -> {
			SwingUtilities.invokeLater(() -> {
				GUIPresentation gui = new GUIPresentation();
				gui.setVisible(true);
			});
		}
		}

	}
}
