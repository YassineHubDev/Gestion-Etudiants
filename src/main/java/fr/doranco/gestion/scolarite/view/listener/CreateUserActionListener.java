package fr.doranco.gestion.scolarite.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.jdatepicker.JDatePicker;

import fr.doranco.gestion.scolarite.entity.User;
import fr.doranco.gestion.scolarite.service.IUserService;
import fr.doranco.gestion.scolarite.service.UserService;
import fr.doranco.gestion.scolarite.view.DashboardComponent;
import fr.doranco.gestion.scolarite.view.utils.ModalDialogUtils;

public class CreateUserActionListener implements ActionListener {
	private JTextField usernameField;
	private JTextField lastnameField;
	private JTextField firstnameField;
	private JDatePicker datePickerField;
	private JTextField emailField;
	private JTextField passwordField;
	private ButtonGroup profiBouttonGroupField;
	private JRadioButton sexeField1;

	private IUserService userService = UserService.getInstance();

	// CONSTRUCTEUR
	public CreateUserActionListener(JTextField usernameField, JTextField lastnameField, JTextField firstnameField,
			JDatePicker datePickerField, JTextField emailField, JTextField passwordField,
			ButtonGroup profiBouttonGroupField, JRadioButton sexeField1) {
		this.usernameField = usernameField;
		this.lastnameField = lastnameField;
		this.firstnameField = firstnameField;
		this.datePickerField = datePickerField;
		this.emailField = emailField;
		this.passwordField = passwordField;
		this.profiBouttonGroupField = profiBouttonGroupField;
		this.sexeField1 = sexeField1;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent2) {

		String username = this.usernameField.getText();
		String lastname = this.lastnameField.getText();
		String firstname = this.firstnameField.getText();
		Date datePicker = (Date) this.datePickerField.getModel().getValue();
		String email = this.emailField.getText();
		String password = this.passwordField.getText();
		String profil = null;

		Enumeration<AbstractButton> allRadioButton = profiBouttonGroupField.getElements();
		while (allRadioButton.hasMoreElements()) {
			JRadioButton temp = (JRadioButton) allRadioButton.nextElement();
			
		}

		String sex = this.sexeField1.getText();

		User user = new User(username, password, lastname, firstname, email, sex, datePicker, profil);

		userService.save(user);

		ModalDialogUtils.showMessage("Utilisateur créé");
		new DashboardComponent().start();
	}

}
