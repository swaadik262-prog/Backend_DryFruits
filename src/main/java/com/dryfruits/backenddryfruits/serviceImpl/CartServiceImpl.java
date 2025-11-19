package com.dryfruits.backenddryfruits.serviceImpl;

import com.dryfruits.backenddryfruits.model.Cart;
import com.dryfruits.backenddryfruits.repository.CartRepository;
import com.dryfruits.backenddryfruits.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Cart saveCartDetails(int userId, Cart cart) {
        cart.setUserId(userId);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public List<Cart> getUserCartDetails(int userId) {
        return cartRepository.getUserCartDetails(userId);
    }
}
