package com.example.democart.model;

import com.example.democart.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    public void clear() {
        items.clear();
    }

    public CartItem addItem(CartItem item) {
        return item;
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getQuantity() * item.getPizza().getPrice();
        }
        return total;
    }
}
