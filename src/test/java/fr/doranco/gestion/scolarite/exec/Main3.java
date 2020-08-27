package fr.doranco.gestion.scolarite.exec;

//MAIN DE MARK

import fr.doranco.gestion.scolarite.entity.Mark;
import fr.doranco.gestion.scolarite.model.dao.DisciplineDAO;
import fr.doranco.gestion.scolarite.model.dao.IDisciplineDAO;
import fr.doranco.gestion.scolarite.model.dao.IMarkDAO;
import fr.doranco.gestion.scolarite.model.dao.IUserDAO;
import fr.doranco.gestion.scolarite.model.dao.MarkDAO;
import fr.doranco.gestion.scolarite.model.dao.UserDAO;



public class Main3 {
	
	public static void main(String[] args) {

		IMarkDAO markDAO = new MarkDAO();
		IUserDAO userDAO = UserDAO.getInstance();
		IDisciplineDAO disciplineDAO = new DisciplineDAO();


		Mark mark = new Mark(15D, "très bon élève", disciplineDAO.findById(1), userDAO.findById(11));

		System.out.println("Note avant ajout dans BDD : " + mark);

		markDAO.save(mark);

		Mark markDB = markDAO.findById(11);
		System.out.println(markDB.getDisciplineMark());

		markDB.getDisciplineMark();
		markDAO.update(markDB);

		//markDAO.delete(markDB);

	}

}
