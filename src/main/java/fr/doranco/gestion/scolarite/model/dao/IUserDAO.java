package fr.doranco.gestion.scolarite.model.dao;

import fr.doranco.gestion.scolarite.entity.User;

public interface IUserDAO extends DAO<User>{
    User getUserByUsername(String username);
}
