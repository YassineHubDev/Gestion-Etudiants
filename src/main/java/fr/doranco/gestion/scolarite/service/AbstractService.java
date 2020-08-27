/**
 * 
 */
package fr.doranco.gestion.scolarite.service;

import java.util.List;

import fr.doranco.gestion.scolarite.model.dao.DAO;

/**
 * @author Aguedo Claudio
 *
 */
public abstract class AbstractService<E, D extends DAO<E>> implements Service<E>{

	protected D entityDAO;
	
	
	protected AbstractService(D entityDAO) {
		super();
		this.entityDAO = entityDAO;
	}

	@Override
	public E save(E entity) {
		return entityDAO.save(entity);
	}

	@Override
	public void update(E entity) {
		entityDAO.update(entity);
	}

	@Override
	public List<E> findAll() {
		return entityDAO.findAll();
	}

	@Override
	public E findById(int id) {
		return entityDAO.findById(id);
	}

	@Override
	public void delete(E entity) {
		entityDAO.delete(entity);
	}
	
}
