package com.example.E_ADMIN.Service;
import com.example.E_ADMIN.Entite.Admin;
import com.example.E_ADMIN.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Override
    public Admin ajouterAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin modifierAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> listAdmin() {
        return adminRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Optional<Admin> GetAdminById(Long id) {
        return adminRepository.findById(id);
    }
}
