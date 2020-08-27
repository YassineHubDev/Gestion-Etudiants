package fr.doranco.gestion.scolarite.service;

import fr.doranco.gestion.scolarite.entity.User;
import fr.doranco.gestion.scolarite.exception.UserInvalidCredentialsException;

public interface IAuthenticationService {
    User login(String username, String password)throws UserInvalidCredentialsException;
}
