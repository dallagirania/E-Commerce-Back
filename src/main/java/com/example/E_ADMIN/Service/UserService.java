package com.example.E_ADMIN.Service;
import com.example.E_ADMIN.Entite.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User ajouterUser(User admin);
    User modifierUser(User admin);
    List<User> listUser();
    void supprimerById(Long id);
    Optional<User> GetUserById(Long id);
}
