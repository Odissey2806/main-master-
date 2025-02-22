package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                totalCost += product.getPrice();
            }
        }
        return totalCost;
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Map.Entry<String, List<Product>> entry : productsMap.entrySet()) {
            for (Product product : entry.getValue()) {
                System.out.println(product);
            }
        }

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount());
    }
    public int specialCount(){
        int specialCount = 0;
        for (List<Product> products : productsMap.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        return specialCount;
    }
    public boolean containsProduct(String name) {
                        return productsMap.containsKey(name);
            }

    public void clearBasket() {
        productsMap.clear();
        }

        public List<Product> removeProductByName(String name){
            return productsMap.remove(name);
    }
}
