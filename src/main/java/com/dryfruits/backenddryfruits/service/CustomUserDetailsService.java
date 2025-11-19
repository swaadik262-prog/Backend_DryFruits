package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.CustomerUserDetails;
import com.dryfruits.backenddryfruits.model.User;
import com.dryfruits.backenddryfruits.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomerUserDetails loadUserByUsername(String phoneNo) throws UsernameNotFoundException {
        User user = userRepository.findByPhoneNo(phoneNo);

        if (user == null) {
            user = userRepository.findByPhoneNo(phoneNo);
        } else {
            return new CustomerUserDetails(
                    user.getId(),
                    user.getPhoneNo(),
                    false, false, false, false
            );
        }

        return new CustomerUserDetails(
                user.getId(),
                user.getPhoneNo(),
                true, true, true, true
        );
    }
}
