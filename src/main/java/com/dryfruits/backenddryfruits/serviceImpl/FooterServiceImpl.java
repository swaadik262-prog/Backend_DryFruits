package com.dryfruits.backenddryfruits.serviceImpl;

import java.util.List;

import com.dryfruits.backenddryfruits.model.Footer;
import com.dryfruits.backenddryfruits.repository.FooterRepository;
import com.dryfruits.backenddryfruits.service.FooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FooterServiceImpl implements FooterService {

    @Autowired
    private FooterRepository footerRepository;

    @Override
    @CacheEvict(value = "websiteFooter", allEntries = true)
    public Footer saveFooter(Footer footer) {
        return footerRepository.save(footer);
    }

    @Override
    @Cacheable(value = "websiteFooter")
    public List<Footer> getAllFooters() {
        return footerRepository.findAll();
    }

    @Override
    public Footer getFooterById(int id) {
        return footerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Footer not found with id: " + id));
    }

    @Override
    @CacheEvict(value = "websiteFooter", allEntries = true)
    public Footer updateFooter(int id, Footer footer) {
        Footer existing = getFooterById(id);

        existing.setName(footer.getName());
        existing.setAboutUs(footer.getAboutUs());
        existing.setEmail(footer.getEmail());
        existing.setContactNo(footer.getContactNo());
        existing.setAddress(footer.getAddress());
        existing.setCopyRightText(footer.getCopyRightText());

        return footerRepository.save(existing);
    }

    @Override
    @CacheEvict(value = "websiteFooter", allEntries = true)
    public void deleteFooter(int id) {
        footerRepository.deleteById(id);
    }
}

