package com.dryfruits.backenddryfruits.repository;

import com.dryfruits.backenddryfruits.model.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductVarietyRepository extends JpaRepository<ProductVariety, Integer> {

    List<ProductVariety> findByDeletedAtIsNull();

    List<ProductVariety> findByProductIdAndDeletedAtIsNull(int productId);
}

