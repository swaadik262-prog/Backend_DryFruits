package com.dryfruits.backenddryfruits.controller;

import com.dryfruits.backenddryfruits.model.Cart;
import com.dryfruits.backenddryfruits.service.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/save_details")
    public ResponseEntity<Cart> saveCartDetails(@RequestBody Cart cart,
                                                HttpServletRequest request) {

        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")){
            token = token.substring(7);
        }

        String[] parts = token.split("\\.");
        String payload = new String(Base64.getDecoder().decode(parts[1]));

        JSONObject jsonPayload = new JSONObject(payload);
        int userId = jsonPayload.getInt("userId");
        return ResponseEntity.ok(cartService.saveCartDetails(userId, cart));
    }

    @GetMapping("/details_user_id")
    public ResponseEntity<List<Cart>> getUserCartDetails(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")){
            token = token.substring(7);
        }

        String[] parts = token.split("\\.");
        String payload = new String(Base64.getDecoder().decode(parts[1]));

        JSONObject jsonPayload = new JSONObject(payload);
        int userId = jsonPayload.getInt("userId");

        return ResponseEntity.ok(cartService.getUserCartDetails(userId));
    }

}

