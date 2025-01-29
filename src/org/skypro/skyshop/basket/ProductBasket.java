package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (Product product : products) {
            totalCost += product.getPrice();
        }
        return totalCost;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
                for (Product product : products) {
                    System.out.println(product.toString());
                }

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount());
    }
    public int specialCount(){
        int specialCount = 0;
        for (Product product : products) {
            if (product.isSpecial()){
                specialCount++;
            }
        }
        return specialCount;
    }
    public boolean containsProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    public void clearBasket() {
        products.clear();
        }

        public List<Product> removeProductByName(String name){
            List<Product> removeProducts = new ArrayList<>();
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(name)) {
                    removeProducts.add(product);
                    iterator.remove();
                }
            }
            return removeProducts;
    }
}
