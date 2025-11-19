package com.dryfruits.backenddryfruits.serviceImpl;

import com.dryfruits.backenddryfruits.model.Product;
import com.dryfruits.backenddryfruits.repository.ProductRepository;
import com.dryfruits.backenddryfruits.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @CacheEvict(value = "allProductsWithVarieties", allEntries = true)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @CacheEvict(value = "allProductsWithVarieties", allEntries = true)
    public Product updateProduct(int id, Product product) {
        Product existing = getProductById(id);

        existing.setName(product.getName());
        existing.setImageUrl(product.getImageUrl());
        existing.setActualPrice(product.getActualPrice());
        existing.setDiscountPrice(product.getDiscountPrice());
        existing.setUnit(product.getUnit());
        existing.setUnitType(product.getUnitType());
        existing.setRating(product.getRating());
        existing.setSold(product.getSold());

        return productRepository.save(existing);
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Product not found with id " + id));
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findByDeletedAtIsNull();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContainingIgnoreCaseAndDeletedAtIsNull(keyword);
    }

    @Override
    @CacheEvict(value = "allProductsWithVarieties", allEntries = true)
    public void softDeleteProduct(int id) {
        Product p = getProductById(id);
        p.setDeletedAt(new Date());
        productRepository.save(p);
    }

    @Override
    @CacheEvict(value = "allProductsWithVarieties", allEntries = true)
    public Product restoreProduct(int id) {
        Product p = getProductById(id);
        p.setDeletedAt(null);
        return productRepository.save(p);
    }

    @Override
    @CacheEvict(value = "allProductsWithVarieties", allEntries = true)
    public void deleteProductPermanently(int id) {
        productRepository.deleteById(id);
    }

    @Override
    @Cacheable(value = "allProductsWithVarieties")
    public List<Map<String, Object>> getAllProductWithVariety() {
        return productRepository.getAllProductWithVariety();
    }

    @Override
    public List<Map<String, Object>> getProductMenuList() {
        return productRepository.getProductMenuList();
    }
}