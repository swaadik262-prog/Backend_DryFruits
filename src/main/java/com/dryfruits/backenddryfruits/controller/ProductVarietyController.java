package com.dryfruits.backenddryfruits.controller;

import com.dryfruits.backenddryfruits.model.ProductVariety;
import com.dryfruits.backenddryfruits.service.ProductVarietyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product_variety")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductVarietyController {

    private final ProductVarietyService service;

    @PostMapping("/create")
    public ResponseEntity<ProductVariety> create(@RequestBody ProductVariety variety) {
        return ResponseEntity.ok(service.createVariety(variety));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductVariety> update(
            @PathVariable int id,
            @RequestBody ProductVariety variety) {
        return ResponseEntity.ok(service.updateVariety(id, variety));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVariety> getVariety(@PathVariable int id) {
        return ResponseEntity.ok(service.getVarietyById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductVariety>> getAll() {
        return ResponseEntity.ok(service.getAllVarieties());
    }

    @GetMapping("/product")
    public ResponseEntity<List<ProductVariety>> getByProduct(@RequestParam int productId) {
        return ResponseEntity.ok(service.getVarietiesByProduct(productId));
    }

    @DeleteMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDelete(@PathVariable int id) {
        service.softDeleteVariety(id);
        return ResponseEntity.ok("Product variety moved to trash");
    }

    @PutMapping("/restore/{id}")
    public ResponseEntity<ProductVariety> restore(@PathVariable int id) {
        return ResponseEntity.ok(service.restoreVariety(id));
    }

    @DeleteMapping("/delete-permanent/{id}")
    public ResponseEntity<String> deletePermanent(@PathVariable int id) {
        service.deleteVarietyPermanent(id);
        return ResponseEntity.ok("Product variety permanently deleted");
    }

    @GetMapping("/search")
    public List<Map<String,Object>> searchProduct(@RequestParam String text) {
        return service.getSearchProducts(text);
    }
}

