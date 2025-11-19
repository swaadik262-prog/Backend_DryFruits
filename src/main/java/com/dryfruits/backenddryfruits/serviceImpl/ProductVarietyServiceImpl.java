package com.dryfruits.backenddryfruits.serviceImpl;

import com.dryfruits.backenddryfruits.model.ProductVariety;
import com.dryfruits.backenddryfruits.repository.ProductVarietyRepository;
import com.dryfruits.backenddryfruits.service.ProductVarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductVarietyServiceImpl implements ProductVarietyService {

    private List<ProductVariety> allProductVarieties = new ArrayList<>();

    private final ProductVarietyRepository repository;

    @Override
    @CacheEvict(value = "productVarieties", allEntries = true)
    public ProductVariety createVariety(ProductVariety variety) {
        allProductVarieties.clear();
        return repository.save(variety);
    }

    @Override
    @CacheEvict(value = "productVarieties", allEntries = true)
    public ProductVariety updateVariety(int id, ProductVariety variety) {
        ProductVariety existing = getVarietyById(id);

        existing.setName(variety.getName());
        existing.setProductId(variety.getProductId());
        existing.setImageUrl(variety.getImageUrl());
        existing.setActualPrice(variety.getActualPrice());
        existing.setDiscountPrice(variety.getDiscountPrice());
        existing.setUnit(variety.getUnit());
        existing.setUnitType(variety.getUnitType());
        existing.setRating(variety.getRating());
        existing.setSold(variety.getSold());
        existing.setQuality(variety.getQuality());
        existing.setProductBenefits(variety.getProductBenefits());

        // finalPrice auto calculated via @PreUpdate

        allProductVarieties.clear();
        return repository.save(existing);
    }

    @Override
    public ProductVariety getVarietyById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product variety not found with id: " + id));
    }

    @Override
    public List<ProductVariety> getAllVarieties() {
        return repository.findByDeletedAtIsNull();
    }

    @Override
    @Cacheable(value = "productVarieties", key = "#productId")
    public List<ProductVariety> getVarietiesByProduct(int productId) {
        return repository.findByProductIdAndDeletedAtIsNull(productId);
    }

    @Override
    @CacheEvict(value = "productVarieties", allEntries = true)
    public void softDeleteVariety(int id) {
        ProductVariety pv = getVarietyById(id);
        pv.setDeletedAt(new Date());
        repository.save(pv);
        allProductVarieties.clear();
    }

    @Override
    @CacheEvict(value = "productVarieties", allEntries = true)
    public ProductVariety restoreVariety(int id) {
        ProductVariety pv = getVarietyById(id);
        pv.setDeletedAt(null);
        allProductVarieties.clear();
        return repository.save(pv);
    }

    @Override
    @CacheEvict(value = "productVarieties", allEntries = true)
    public void deleteVarietyPermanent(int id) {
        repository.deleteById(id);
        allProductVarieties.clear();
    }

    @Override
    public List<Map<String, Object>> getSearchProducts(String text) {

        if (allProductVarieties.isEmpty()) {
            List<ProductVariety> allProduct = getAllVarieties();
            allProductVarieties.addAll(allProduct);
        }

        if (text == null || text.trim().isEmpty()) {
            return new ArrayList<>();
        }
        String keyword = text.toLowerCase();
        List<Map<String, Object>> result = new ArrayList<>();

        for (ProductVariety variety : allProductVarieties) {
            if (variety.getName().toLowerCase().contains(keyword)) {

                Map<String, Object> map = Map.of(
                        "id", variety.getId(),
                        "name", variety.getName(),
                        "productId", variety.getProductId()
                );
                result.add(map);
            }
        }
        return result;
    }
}

