package com.dryfruits.backenddryfruits.controller;

import java.util.List;

import com.dryfruits.backenddryfruits.model.Slider;
import com.dryfruits.backenddryfruits.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sliders")
@CrossOrigin("*")
public class SliderController {

    @Autowired
    private SliderService sliderService;

    // Create Slider
    @PostMapping("/create")
    public ResponseEntity<Slider> createSlider(@RequestBody Slider slider) {
        return ResponseEntity.ok(sliderService.saveSlider(slider));
    }

    // Get All Sliders
    @GetMapping("/all")
    public ResponseEntity<List<Slider>> getAllSliders() {
        return ResponseEntity.ok(sliderService.getAllSliders());
    }

    // Get Slider By ID
    @GetMapping("/{id}")
    public ResponseEntity<Slider> getSliderById(@PathVariable int id) {
        return ResponseEntity.ok(sliderService.getSliderById(id));
    }

    // Update Slider
    @PutMapping("/update/{id}")
    public ResponseEntity<Slider> updateSlider(@PathVariable int id, @RequestBody Slider slider) {
        return ResponseEntity.ok(sliderService.updateSlider(id, slider));
    }

    // Delete Slider
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSlider(@PathVariable int id) {
        sliderService.deleteSlider(id);
        return ResponseEntity.ok("Slider deleted successfully");
    }
}


