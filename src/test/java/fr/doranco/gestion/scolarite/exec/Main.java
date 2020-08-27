package fr.doranco.gestion.scolarite.exec;

//MAIN DE USER

import java.util.List;

import fr.doranco.gestion.scolarite.model.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.gestion.scolarite.entity.User;
import fr.doranco.gestion.scolarite.model.dao.IUserDAO;
import fr.doranco.gestion.scolarite.utils.Dates;
import fr.doranco.gestion.scolarite.utils.HibernateUtils;

public class Main {

	public static void main(String[] args) {

		IUserDAO userDAO = UserDAO.getInstance();

		User user = new User("Alberto", "doranco20", "Enstein", "Albert", "a.ensteing2@enstein.com", "male",
				Dates.convertStringToDateUtil("15/01/2020"), "Teacher");
		// user.setUsername(username);

		System.out.println("User avant ajout dans BDD : " + user);

		userDAO.save(user);

		User userDB = userDAO.findById(4);
		System.out.println(userDB.getFirstname());

		userDB.setFirstname("John");
		userDAO.update(userDB);

		userDAO.delete(userDB);

		System.out.println("");
		System.out.println("User aprs ajout dans la BDD : " + user);
		// System.out.println("Username : " + user.getUsername());

		System.exit(0);

		User user1 = new User("Alberto", "doranco20", "Enstein", "Albert", "a.ensteing2@enstein.com", "male",
				Dates.convertStringToDateUtil("15/01/2020"), "Teacher");
		User user2 = new User("Victorio", "doranco22", "Hugo", "Victor", "a.ensteing3@enstein.com", "male",
				Dates.convertStringToDateUtil("10/01/2000"), "Student");

		Transaction transaction = null;

		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			transaction = session.beginTransaction();
			session.save(user1);
			session.save(user2);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			List<User> listeUsers = session.createQuery("from User", User.class).list();

			for (User u : listeUsers) {
				System.out.println(u);
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		System.exit(1);
	}
}
