package fr.doranco.gestion.scolarite.model.dao;

import fr.doranco.gestion.scolarite.entity.Mark;

public class MarkDAO extends AbstractDAO<Mark> implements IMarkDAO {
	
	public MarkDAO() {
		super(Mark.class);
	}
}

