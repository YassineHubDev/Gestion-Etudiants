/**
 * 
 */
package fr.doranco.gestion.scolarite.service;

import java.util.List;

/**
 * @author Aguedo Claudio 
 *
 */
public interface Service<E> {

	E save(E entity);

	void update(E entity);

	List<E> findAll();

	E findById(int id);

	void delete(E entity);
}