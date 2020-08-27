/**
 * 
 */
package fr.doranco.gestion.scolarite.service;

import fr.doranco.gestion.scolarite.entity.User;
import fr.doranco.gestion.scolarite.model.dao.UserDAO;

/**
 * @author Aguedo Claudio
 *
 */
public class UserService extends AbstractService<User, UserDAO> implements IUserService {
	private static final UserService INSTANCE = new UserService();

	private UserService() {
		super(UserDAO.getInstance());
	}

	@Override
	public User getUserByUsername(String username) {
		return entityDAO.getUserByUsername(username);
	}

	public static UserService getInstance() {
		return INSTANCE;
	}
}
