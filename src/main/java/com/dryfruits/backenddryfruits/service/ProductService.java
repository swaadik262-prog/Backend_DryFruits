package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    Product createProduct(Product product);

    Product updateProduct(int id, Product product);

    Product getProductById(int id);

    List<Product> getAllProducts();

    List<Product> searchProducts(String keyword);

    void softDeleteProduct(int id);

    Product restoreProduct(int id);

    void deleteProductPermanently(int id);

    List<Map<String, Object>> getAllProductWithVariety();

    List<Map<String, Object>> getProductMenuList();
}

