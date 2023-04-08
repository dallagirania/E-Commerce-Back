package com.example.E_ADMIN.Repository;

import com.example.E_ADMIN.Entite.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    User findIdByEmail(String email);
    boolean existsByEmail(String email);

}
