package com.dryfruits.backenddryfruits.serviceImpl;

import java.util.Date;
import java.util.List;

import com.dryfruits.backenddryfruits.model.User;
import com.dryfruits.backenddryfruits.repository.UserRepository;
import com.dryfruits.backenddryfruits.service.UserService;
import com.dryfruits.backenddryfruits.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public User saveUser(User user) {
        String token = jwtUtil.generateToken(user.getPhoneNo(), user.getId());
        user.setToken(token);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public User updateUser(int id, User user) {
        User existing = getUserById(id);

        existing.setName(user.getName());
        existing.setPhoneNo(user.getPhoneNo());
        existing.setEmail(user.getEmail());
        existing.setProfileImage(user.getProfileImage());
        existing.setAddress(user.getAddress());

        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(int id) {
        User user = getUserById(id);
        user.setDeletedAt(new Date());
        userRepository.save(user); // soft delete
    }
}

