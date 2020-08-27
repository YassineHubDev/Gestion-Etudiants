package fr.doranco.gestion.scolarite.model.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class AbstractDAO<E> implements DAO<E>{

    protected Session session = HibernateDataSource.getInstance().getSession();
    @SuppressWarnings("rawtypes")
	private Class clazz;

    protected AbstractDAO(@SuppressWarnings("rawtypes") Class clazz){
        this.clazz = clazz;
    }

    public E save(E entity) {
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return entity;
    }

    @Override
    public void update(E entity) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
    }

    @Override
    public E findById(int id) {
        if (id <= 0) {
            throw new NullPointerException("l'identifiant de ne doit pas tre <= 0");
        }
        return (E) session.get(this.clazz, id);
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(this.clazz);
        Root<E> rootEntry = cq.from(this.clazz);
        CriteriaQuery<E> all = cq.select(rootEntry);
        TypedQuery<E> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public void delete(E entity) {
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
    }
}
