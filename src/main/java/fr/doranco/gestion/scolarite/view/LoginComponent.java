package fr.doranco.gestion.scolarite.view;

import fr.doranco.gestion.scolarite.view.listener.SignInActionListener;
import fr.doranco.gestion.scolarite.view.pages.user.UserComponent;
import fr.doranco.gestion.scolarite.view.utils.ModalDialogUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginComponent{

    public void start(){
        JFrame loginFrame = new JFrame();

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(new EmptyBorder(new Insets(20, 20, 15, 20)));
        JLabel titleLogin = new JLabel("Connection");
        loginPanel.add(titleLogin, Component.CENTER_ALIGNMENT);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 40)));

        loginPanel.add(new JLabel("Nom d'utilisateur"));
        JTextField usernameField = new JTextField();
        loginPanel.add(usernameField, Component.LEFT_ALIGNMENT);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        loginPanel.add(new JLabel("Mot de passe"));
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton signInButton = new JButton("Se connecter");
        signInButton.addActionListener(new SignInActionListener(loginFrame, usernameField, passwordField));
        loginPanel.add(signInButton);
        loginFrame.add(loginPanel);

        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);//making the frame visible
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
