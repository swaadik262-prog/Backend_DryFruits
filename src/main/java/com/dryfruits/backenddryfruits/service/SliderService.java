package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Slider;

import java.util.List;

public interface SliderService {

    Slider saveSlider(Slider slider);

    List<Slider> getAllSliders();

    Slider getSliderById(int id);

    Slider updateSlider(int id, Slider slider);

    void deleteSlider(int id);
}
