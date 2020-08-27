package fr.doranco.gestion.scolarite.model.dao;

import fr.doranco.gestion.scolarite.entity.Discipline;

public class DisciplineDAO extends AbstractDAO<Discipline> implements IDisciplineDAO {

	public DisciplineDAO() {
		super(Discipline.class);
	}
}
