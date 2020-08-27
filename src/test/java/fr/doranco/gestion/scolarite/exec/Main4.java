package fr.doranco.gestion.scolarite.exec;


//MAIN DE SCHOOL REPORT

import fr.doranco.gestion.scolarite.entity.SchoolReport;
import fr.doranco.gestion.scolarite.model.dao.ISchoolReportDAO;
import fr.doranco.gestion.scolarite.model.dao.IUserDAO;
import fr.doranco.gestion.scolarite.model.dao.SchoolReportDAO;
import fr.doranco.gestion.scolarite.model.dao.UserDAO;

public class Main4 {
	
	public static void main(String[] args) {

		ISchoolReportDAO schoolReportDAO = new SchoolReportDAO();
		IUserDAO userDAO = UserDAO.getInstance();


		SchoolReport schoolReport = new SchoolReport(15D, 15D, "excellent", userDAO.findById(11));

		System.out.println("Bulletin avant ajout dans BDD : " + schoolReport);

		schoolReportDAO.save(schoolReport);

		SchoolReport schoolReportDB = schoolReportDAO.findById(11);
		System.out.println(schoolReportDB.getDisciplineAverage());

		schoolReportDB.getDisciplineAverage();
		schoolReportDAO.update(schoolReportDB);

		//markDAO.delete(markDB);

	}

}
