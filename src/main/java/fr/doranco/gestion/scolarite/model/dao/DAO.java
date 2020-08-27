package fr.doranco.gestion.scolarite.model.dao;

import java.util.List;

public interface DAO<E> {

	E save(E entity);

	void update(E entity);

	List<E> findAll();

	E findById(int id);

	void delete(E entity);
}
