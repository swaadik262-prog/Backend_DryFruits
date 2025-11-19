package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Admin;

import java.util.List;

public interface AdminService {

    Admin saveAdmin(Admin admin);

    List<Admin> getAllAdmins();

    Admin getAdminById(int id);

    Admin updateAdmin(int id, Admin admin);

    void deleteAdmin(int id);
}

