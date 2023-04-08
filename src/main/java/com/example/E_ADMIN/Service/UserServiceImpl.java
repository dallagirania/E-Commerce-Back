package com.example.E_ADMIN.Service;

import com.example.E_ADMIN.Entite.User;
import com.example.E_ADMIN.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public User ajouterUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User modifierUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> GetUserById(Long id) {
        return userRepository.findById(id);
    }
}

