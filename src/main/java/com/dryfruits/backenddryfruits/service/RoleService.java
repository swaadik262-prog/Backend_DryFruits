package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Role;

import java.util.List;

public interface RoleService {

    Role saveRole(Role role);

    List<Role> getAllRoles();

    Role getRoleById(int id);

    Role updateRole(int id, Role role);

    void deleteRole(int id);
}
