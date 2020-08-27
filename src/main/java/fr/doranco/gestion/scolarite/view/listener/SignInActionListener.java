package fr.doranco.gestion.scolarite.view.listener;

import fr.doranco.gestion.scolarite.exception.UserInvalidCredentialsException;
import fr.doranco.gestion.scolarite.service.AuthenticationService;
import fr.doranco.gestion.scolarite.service.IAuthenticationService;
import fr.doranco.gestion.scolarite.view.DashboardComponent;
import fr.doranco.gestion.scolarite.view.utils.ModalDialogUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInActionListener implements ActionListener {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private IAuthenticationService authenticationService = new AuthenticationService();

    public SignInActionListener(JFrame loginFrame, JTextField usernameField, JPasswordField passwordField) {
        this.loginFrame = loginFrame;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            String username = this.usernameField.getText();
            String password = new String(this.passwordField.getPassword());

            /**
             * Des validations de données
             */
            // Validation de mot de passe et nom d'utilisateur contre le service d'authentification
            this.authenticationService.login(username, password);
            loginFrame.setVisible(false);
            ModalDialogUtils.showMessage("Vous êtes bien connecté!");
            new DashboardComponent().start();
        } catch (UserInvalidCredentialsException e) {
            ModalDialogUtils.showErrorMessage("Vérifiez vos identifiants");
        }

    }
}
