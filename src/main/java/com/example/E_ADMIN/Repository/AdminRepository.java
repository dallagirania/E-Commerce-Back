package com.example.E_ADMIN.Repository;
import com.example.E_ADMIN.Entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findIdByEmail(String email);
    boolean existsByEmail(String email);
}
