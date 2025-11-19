package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPhoneNo(String phoneNo);
}

