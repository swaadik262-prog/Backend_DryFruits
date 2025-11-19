package com.dryfruits.backenddryfruits.serviceImpl;

import java.util.List;

import com.dryfruits.backenddryfruits.model.Slider;
import com.dryfruits.backenddryfruits.repository.SliderRepository;
import com.dryfruits.backenddryfruits.service.SliderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class SliderServiceImpl implements SliderService {

    @Autowired
    private SliderRepository sliderRepository;

    @Override
    @CacheEvict(value = "allSliders", allEntries = true)
    public Slider saveSlider(Slider slider) {
        return sliderRepository.save(slider);
    }

    @Override
    @Cacheable(value = "allSliders")
    public List<Slider> getAllSliders() {
        return sliderRepository.findAll();
    }

    @Override
    public Slider getSliderById(int id) {
        return sliderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slider not found with id: " + id));
    }

    @Override
    @CacheEvict(value = "allSliders", allEntries = true)
    public Slider updateSlider(int id, Slider slider) {
        Slider existingSlider = getSliderById(id);

        existingSlider.setName(slider.getName());
        existingSlider.setImage(slider.getImage());
        existingSlider.setLinkPage(slider.getLinkPage());

        return sliderRepository.save(existingSlider);
    }

    @Override
    @CacheEvict(value = "allSliders", allEntries = true)
    public void deleteSlider(int id) {
        sliderRepository.deleteById(id);
    }
}

