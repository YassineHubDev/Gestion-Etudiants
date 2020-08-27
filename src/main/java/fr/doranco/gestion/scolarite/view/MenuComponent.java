package fr.doranco.gestion.scolarite.view;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MenuComponent extends JMenuBar {

	public MenuComponent() {
		JMenu menuPages = new JMenu("Pages");
		menuPages.setMnemonic(KeyEvent.VK_P);
		menuPages.getAccessibleContext().setAccessibleDescription("Cliquez pour voir les pages disponibles");
		this.add(menuPages);

		this.add(Box.createHorizontalGlue());

		JMenu userFunctions = new JMenu("Compte");
		userFunctions.setMnemonic(KeyEvent.VK_C);
		userFunctions.getAccessibleContext().setAccessibleDescription("Cliquez pour voir les fonctions disponibles");
		this.add(userFunctions);
	}
}
