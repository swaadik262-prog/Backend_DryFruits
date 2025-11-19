package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.ProductVariety;

import java.util.List;
import java.util.Map;

public interface ProductVarietyService {

    ProductVariety createVariety(ProductVariety variety);

    ProductVariety updateVariety(int id, ProductVariety variety);

    ProductVariety getVarietyById(int id);

    List<ProductVariety> getAllVarieties();

    List<ProductVariety> getVarietiesByProduct(int productId);

    void softDeleteVariety(int id);

    ProductVariety restoreVariety(int id);

    void deleteVarietyPermanent(int id);

    List<Map<String, Object>> getSearchProducts(String text);
}
