package fr.doranco.gestion.scolarite.view.pages.user;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import fr.doranco.gestion.scolarite.service.IUserService;
import fr.doranco.gestion.scolarite.service.UserService;

public class UserComponent extends JPanel {
    private IUserService userService = UserService.getInstance();
    public UserComponent(JFrame frame){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel body = new JPanel();
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setBorder(new EmptyBorder(new Insets(20, 20, 15, 20)));

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        header.add(new JLabel("Utilisateurs"));
        header.add(Box.createHorizontalGlue());
        JButton createUserButton =new JButton("Nouveau");
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new AddUserModalComponent(frame).setVisible(true);
            }
        });
        header.add(createUserButton);
        body.add(header);
        body.add(Box.createRigidArea(new Dimension(0, 40)));
        
        UserTableComponent userTableComponent = new UserTableComponent(); 
        body.add(new JScrollPane(userTableComponent));
        userTableComponent.update(null, userService.findAll());
        this.add(body);
    }
}
