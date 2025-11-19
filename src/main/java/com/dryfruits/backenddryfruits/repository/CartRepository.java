package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "select * from cart where user_id =:userId", nativeQuery = true)
    List<Cart> getUserCartDetails(int userId);
}
