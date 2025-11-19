package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
