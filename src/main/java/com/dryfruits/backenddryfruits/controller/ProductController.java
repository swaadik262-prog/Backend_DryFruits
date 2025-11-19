package com.dryfruits.backenddryfruits.controller;

import com.dryfruits.backenddryfruits.model.Product;
import com.dryfruits.backenddryfruits.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }

    @DeleteMapping("/soft-delete/{id}")
    public String softDeleteProduct(@PathVariable int id) {
        productService.softDeleteProduct(id);
        return "Product moved to trash!";
    }

    @PutMapping("/restore/{id}")
    public Product restoreProduct(@PathVariable int id) {
        return productService.restoreProduct(id);
    }

    @DeleteMapping("/delete-permanent/{id}")
    public String deletePermanent(@PathVariable int id) {
        productService.deleteProductPermanently(id);
        return "Product deleted permanently.";
    }

    @GetMapping("/with_variety")
    public List<Map<String, Object>> productWithVariety() {
        return productService.getAllProductWithVariety();
    }

    @GetMapping("/menu")
    public List<Map<String,Object>> getProductMenuList() {
        return productService.getProductMenuList();
    }
}
