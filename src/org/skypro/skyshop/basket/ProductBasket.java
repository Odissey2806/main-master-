package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int count = 0;

    public void addProduct(Product product) {
        if (count < products.length) {
            products[count] = product;
            count++;
        } else {
            System.out.println("Невозможно добавить продукт");
        }
    }
    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < count; i++) {
            totalCost += products[i].getCost();
        }
        return totalCost;
    }
    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getCost());
        }
        System.out.println("Итого: " + getTotalCost());
    }
    public boolean containsProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void clearBasket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
        count = 0;
    }

}
