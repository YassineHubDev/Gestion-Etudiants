package fr.doranco.gestion.scolarite.exec;

//MAIN DE DISCIPLINE

import fr.doranco.gestion.scolarite.model.dao.UserDAO;
import fr.doranco.gestion.scolarite.entity.Discipline;
import fr.doranco.gestion.scolarite.model.dao.DisciplineDAO;
import fr.doranco.gestion.scolarite.model.dao.IDisciplineDAO;
import fr.doranco.gestion.scolarite.model.dao.IUserDAO;

public class Main2 {

	public static void main(String[] args) {

		IDisciplineDAO disciplineDAO = new DisciplineDAO();
		IUserDAO userDAO = UserDAO.getInstance();

		Discipline discipline = new Discipline("Math", userDAO.findById(11));

		System.out.println("Discipline avant ajout dans BDD : " + discipline);

		disciplineDAO.save(discipline);

		Discipline disciplineDB = disciplineDAO.findById(11);
		System.out.println(disciplineDB.getNameDiscipline());

		disciplineDB.getNameDiscipline();
		disciplineDAO.update(disciplineDB);

		//disciplineDAO.delete(disciplineDB);

	}

}
