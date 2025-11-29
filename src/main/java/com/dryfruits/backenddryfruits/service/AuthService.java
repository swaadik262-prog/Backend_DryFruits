package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.dto.LoginRequest;

public interface AuthService {
    String login(LoginRequest request);
}
