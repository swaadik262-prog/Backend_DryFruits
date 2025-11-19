package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}