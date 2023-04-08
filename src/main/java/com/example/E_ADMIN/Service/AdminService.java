package com.example.E_ADMIN.Service;
import com.example.E_ADMIN.Entite.Admin;
import java.util.List;
import java.util.Optional;

public interface AdminService {

        Admin ajouterAdmin(Admin admin);
        Admin modifierAdmin(Admin admin);
        List<Admin> listAdmin();
        void supprimerById(Long id);
        Optional<Admin> GetAdminById(Long id);
    }


