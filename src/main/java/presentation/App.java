package presentation;

import javax.swing.SwingUtilities;

import presentation.presentationMode.EPresentationMode;

public class App {

	public static void main(String[] args) {

		EPresentationMode mode = EPresentationMode.GUI;

		switch (mode) {
		case CONSOLE -> new ConsoleApp().executeConsoleApp();
		case GUI -> SwingUtilities.invokeLater(() -> new GUIPresentation().setVisible(true));
		}

	}
}
