package com.dryfruits.backenddryfruits.serviceImpl;

import java.util.List;

import com.dryfruits.backenddryfruits.model.Admin;
import com.dryfruits.backenddryfruits.repository.AdminRepository;
import com.dryfruits.backenddryfruits.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin getAdminById(int id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
    }

    @Override
    public Admin updateAdmin(int id, Admin admin) {
        Admin existingAdmin = getAdminById(id);

        existingAdmin.setName(admin.getName());
        existingAdmin.setPhoneNo(admin.getPhoneNo());
        existingAdmin.setEmail(admin.getEmail());
        existingAdmin.setRoleId(admin.getRoleId());

        return adminRepository.save(existingAdmin);
    }

    @Override
    public void deleteAdmin(int id) {
        adminRepository.deleteById(id);
    }
}

