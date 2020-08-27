package fr.doranco.gestion.scolarite.view;

import javax.swing.*;

import fr.doranco.gestion.scolarite.view.pages.user.UserComponent;

public class DashboardComponent {

	public void start() {
		JFrame appFrame = new JFrame();// creating instance of JFrame

		appFrame.setJMenuBar(new MenuComponent());
		appFrame.add(new UserComponent(appFrame));

		appFrame.setSize(700, 500);// 400 width and 500 height
		// app.setLayout(null);//using no layout managers
		appFrame.setVisible(true);// making the frame visible
		appFrame.setLocationRelativeTo(null);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
