package com.example.democart.controller;

import com.example.democart.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckoutController {
    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("items", shoppingCart.getItems());
        model.addAttribute("total", shoppingCart.getTotal());
        return "checkout";
    }

    @PostMapping("/checkout")
    public String processOrder() {
        shoppingCart.clear();
        return "order-confirmation";
    }
}
