package presentation;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {

		boolean consolePresentation = false;

		if (consolePresentation) {
			ConsoleApp consoleApp = new ConsoleApp();
			consoleApp.executeConsoleApp();
		} else {
			SwingUtilities.invokeLater(() -> {
				GUIPresentation gui = new GUIPresentation();
				gui.setVisible(true);

			});
		}

	}
}
