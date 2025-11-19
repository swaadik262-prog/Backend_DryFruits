package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Footer;

import java.util.List;

public interface FooterService {

    Footer saveFooter(Footer footer);

    List<Footer> getAllFooters();

    Footer getFooterById(int id);

    Footer updateFooter(int id, Footer footer);

    void deleteFooter(int id);
}

