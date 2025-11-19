package com.dryfruits.backenddryfruits.service;

import com.dryfruits.backenddryfruits.model.Cart;

import java.util.List;

public interface CartService {
    Cart saveCartDetails(int userId, Cart cart);

    List<Cart> getUserCartDetails(int userId);
}
