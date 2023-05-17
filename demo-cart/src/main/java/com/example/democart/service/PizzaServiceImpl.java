package com.example.democart.service;

import com.example.democart.model.Pizza;
import com.example.democart.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PizzaServiceImpl implements PizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @Override
    public void savePizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElse(null);
    }
    
// new write pizza remove methode
    @Override
    public void removepizza(Long id) {
        pizzaRepository.deleteAllById(Collections.singleton(id));
    }
}
