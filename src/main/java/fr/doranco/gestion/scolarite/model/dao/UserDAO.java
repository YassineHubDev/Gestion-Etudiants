package fr.doranco.gestion.scolarite.model.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.gestion.scolarite.entity.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO{
	
    private static final UserDAO INSTANCE = new UserDAO();
    
    //CONSTRUCTEUR
    private UserDAO() {
        super(User.class);
    }

    @Override
    public User getUserByUsername(String username) {
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root).where(builder.equal(root.get("username"), username));
        Query<User> q = session.createQuery(query);
        User user = null;
        if(q.uniqueResultOptional().isPresent())
            user = q.getSingleResult();
        transaction.commit();
        return user;
    }

    //METHODE getInstance
    public static UserDAO getInstance(){
        return INSTANCE;
    }
}
