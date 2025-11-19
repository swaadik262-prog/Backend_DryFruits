package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByDeletedAtIsNull();   // Active products only

    List<Product> findByNameContainingIgnoreCaseAndDeletedAtIsNull(String name);

    @Query(value = "SELECT p.id, p.image_url, p.name, p.actual_price, p.discount_price, p.final_price, \n" +
            "p.rating, p.sold, GROUP_CONCAT(pv.name SEPARATOR ', ') AS varieties\n" +
            "FROM product p LEFT JOIN product_variety pv ON pv.product_id = p.id GROUP BY p.id", nativeQuery = true)
    List<Map<String,Object>> getAllProductWithVariety();

    @Query(value = "select id, name from product", nativeQuery = true)
    List<Map<String, Object>> getProductMenuList();
}

