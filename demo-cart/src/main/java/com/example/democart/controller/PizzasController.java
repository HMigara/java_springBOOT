package com.example.democart.controller;

import com.example.democart.model.CartItem;
import com.example.democart.model.Pizza;
import com.example.democart.service.PizzaService;
import com.example.democart.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
public class PizzasController {
    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/pizzas")
    public String pizzas(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "pizzas";
    }

    @PostMapping("/pizzas")
    public String addPizza(@ModelAttribute Pizza pizza, Model model) {
        pizzaService.savePizza(pizza);
        return "redirect:/pizzas";
    }
    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/getpizza")
    public String getPizzas(Model model) {
        model.addAttribute("pizzas", pizzaService.getAllPizzas());
        return "pizzas";
    }

    @PostMapping("/addcart/{id}")
    @ResponseBody
    public CartItem addToCart(@PathVariable Long id, Model model) {
        Pizza pizza = pizzaService.getPizzaById(id);
        if (Objects.nonNull(pizza)) {
            CartItem item = new CartItem(pizza,1);
            return shoppingCart.addItem(item);
        }else{
            return null;
        }
    }


    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("items", shoppingCart.getItems());
        model.addAttribute("total", shoppingCart.getTotal());
        return "cart";
    }

    @GetMapping("/removecart/{index}")
    public String removeFromCart(@PathVariable int index, Model model) {
        shoppingCart.removeItem(index);
        return "redirect:/cart";
    }

}
