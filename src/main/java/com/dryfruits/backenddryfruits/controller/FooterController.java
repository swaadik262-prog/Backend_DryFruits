package com.dryfruits.backenddryfruits.controller;

import java.util.List;

import com.dryfruits.backenddryfruits.model.Footer;
import com.dryfruits.backenddryfruits.service.FooterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/footer")
@CrossOrigin("*")
public class FooterController {

    @Autowired
    private FooterService footerService;

    // Create Footer
    @PostMapping("/create")
    public ResponseEntity<Footer> createFooter(@Valid @RequestBody Footer footer) {
        return ResponseEntity.ok(footerService.saveFooter(footer));
    }

    // Get All Footers
    @GetMapping("/all")
    public ResponseEntity<List<Footer>> getAllFooters() {
        return ResponseEntity.ok(footerService.getAllFooters());
    }

    // Get Footer By ID
    @GetMapping("/{id}")
    public ResponseEntity<Footer> getFooterById(@PathVariable int id) {
        return ResponseEntity.ok(footerService.getFooterById(id));
    }

    // Update Footer
    @PutMapping("/update/{id}")
    public ResponseEntity<Footer> updateFooter(@PathVariable int id, @Valid @RequestBody Footer footer) {
        return ResponseEntity.ok(footerService.updateFooter(id, footer));
    }

    // Delete Footer
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFooter(@PathVariable int id) {
        footerService.deleteFooter(id);
        return ResponseEntity.ok("Footer deleted successfully");
    }
}


