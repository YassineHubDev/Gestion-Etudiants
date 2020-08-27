package fr.doranco.gestion.scolarite.view.pages.user;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class UpdateUserModalComponent extends JDialog {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1969722909488185730L;
	
	
	private int userId;
	
	public UpdateUserModalComponent(JFrame owner, int userId) {
		super(owner, "Modification d'utilisateur", true);
		this.userId = userId;
		System.out.println(userId);
		
		//Recuperer l'utilisateur de la base de données avec la variable userId
		//Créer les champs du formulaire
		//Modifier l'object user, récuperer depuis de la base de données, avec les informations du formulaire
		//Appeler la methode update du service userService pour stocker les nouvelles informations
		
		
		this.pack();
		this.setLocationRelativeTo(null);
	}
}
