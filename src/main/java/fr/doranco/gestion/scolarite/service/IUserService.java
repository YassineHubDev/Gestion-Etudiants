/**
 * 
 */
package fr.doranco.gestion.scolarite.service;

import fr.doranco.gestion.scolarite.entity.User;

/**
 * @author Aguedo Claudio
 *
 */
public interface IUserService extends Service<User> {
	User getUserByUsername(String username);
}
