package com.dryfruits.backenddryfruits.serviceImpl;

import com.dryfruits.backenddryfruits.dto.LoginRequest;
import com.dryfruits.backenddryfruits.model.User;
import com.dryfruits.backenddryfruits.repository.UserRepository;
import com.dryfruits.backenddryfruits.service.AuthService;
import com.dryfruits.backenddryfruits.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtService;

    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());

        if (user.getEmail().isEmpty()) {
            return "Email not registered";
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateUserToken(user);
    }
}

