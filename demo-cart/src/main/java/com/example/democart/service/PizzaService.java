package com.example.democart.service;

import com.example.democart.model.Pizza;
import java.util.List;

public interface PizzaService {
    public List<Pizza> getAllPizzas();
    public void savePizza(Pizza pizza);
   public Pizza getPizzaById(Long id);

   public void removepizza(Long id);
}
