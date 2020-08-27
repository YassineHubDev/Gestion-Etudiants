package fr.doranco.gestion.scolarite.view.pages.user;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Properties;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import fr.doranco.gestion.scolarite.utils.Profile;
import fr.doranco.gestion.scolarite.utils.Sexe;
import fr.doranco.gestion.scolarite.view.listener.CreateUserActionListener;

public class AddUserModalComponent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7215153804712458651L;

	public AddUserModalComponent(JFrame owner) {
		super(owner, "Création d'utilisateur", true);

		JPanel userAddPanel = new JPanel();
		userAddPanel.setLayout(new BoxLayout(userAddPanel, BoxLayout.Y_AXIS));
		userAddPanel.setBorder(new EmptyBorder(new Insets(20, 20, 15, 20)));

		JLabel titleLogin = new JLabel("Renseignez les champs nécessaire pour la création d'un nouvel utilisateur");
		userAddPanel.add(titleLogin, Component.CENTER_ALIGNMENT);

		userAddPanel.add(Box.createRigidArea(new Dimension(0, 40)));

		userAddPanel.add(new JLabel("Profile"));
		// Création boutons radio
		JRadioButton profileField1 = new JRadioButton(Profile.PROFESSEUR.name());
		JRadioButton profileField2 = new JRadioButton(Profile.ETUDIANT.name());
		userAddPanel.add(profileField1, Component.LEFT_ALIGNMENT);
		userAddPanel.add(profileField2, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		ButtonGroup profiBouttonGroupField = new ButtonGroup();
		profiBouttonGroupField.add(profileField1);
		profiBouttonGroupField.add(profileField2);
		
		
		
		
		userAddPanel.add(new JLabel("Nom d'utilisateur"));
		JTextField usernameField = new JTextField();
		userAddPanel.add(usernameField, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		// creation boutons sexe
		userAddPanel.add(new JLabel("Sexe"));
		// Création boutons radio
		JRadioButton sexeField1 = new JRadioButton(Sexe.HOMME.name());
		JRadioButton sexeField2 = new JRadioButton(Sexe.FEMME.name());
		userAddPanel.add(sexeField1, Component.LEFT_ALIGNMENT);
		userAddPanel.add(sexeField2, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

	

		userAddPanel.add(new JLabel("Nom"));
		JTextField lastnameField = new JTextField();
		userAddPanel.add(lastnameField, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		userAddPanel.add(new JLabel("Prénom"));
		JTextField firstnameField = new JTextField();
		userAddPanel.add(firstnameField, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		userAddPanel.add(new JLabel("Date de naissance"));

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		JDatePanelImpl dateOfBirthField = new JDatePanelImpl(model, p);
		JDatePickerImpl datePickerField = new JDatePickerImpl(dateOfBirthField, new DateFormatter());
		
		
		userAddPanel.add(datePickerField);

		userAddPanel.add(dateOfBirthField, Component.LEFT_ALIGNMENT);
		// userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		userAddPanel.add(new JLabel("Email"));
		JTextField emailField = new JTextField();
		userAddPanel.add(emailField, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		userAddPanel.add(new JLabel("Mot de passe"));
		JPasswordField passwordField = new JPasswordField();
		userAddPanel.add(passwordField, Component.LEFT_ALIGNMENT);
		userAddPanel.add(Box.createRigidArea(new Dimension(0, 20)));

		JButton createUser = new JButton("Créer utilisateur");
		createUser.addActionListener(new CreateUserActionListener(usernameField, lastnameField, firstnameField,
				datePickerField, emailField, passwordField, profiBouttonGroupField, sexeField1));

		userAddPanel.add(createUser);

		/**/
		this.add(userAddPanel);
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
