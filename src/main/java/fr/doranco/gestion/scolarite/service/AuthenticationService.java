package fr.doranco.gestion.scolarite.service;

import fr.doranco.gestion.scolarite.entity.User;
import fr.doranco.gestion.scolarite.exception.UserInvalidCredentialsException;

public class AuthenticationService implements IAuthenticationService {
	private IUserService userService = UserService.getInstance();

	@Override
	public User login(String username, String password) throws UserInvalidCredentialsException {
		User user = this.userService.getUserByUsername(username);
		// Mettre en place une validation en hash
		if (user == null || !user.getPassword().equals(password))
			throw new UserInvalidCredentialsException();
		return user;
	}
}
