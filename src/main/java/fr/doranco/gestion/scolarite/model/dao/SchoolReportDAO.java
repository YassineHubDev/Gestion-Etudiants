package fr.doranco.gestion.scolarite.model.dao;

import fr.doranco.gestion.scolarite.entity.SchoolReport;

public class SchoolReportDAO extends AbstractDAO<SchoolReport> implements ISchoolReportDAO{

	public SchoolReportDAO() {
		super(SchoolReport.class);
	}
}
