package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Apple", 50);
        Product banana = new DiscountedProduct("Banana", 30,10);
        Product orange = new FixPriceProduct("Orange");
        Product mango = new SimpleProduct("Mango", 60);
        Product pineapple = new DiscountedProduct("Pineapple", 70,20);
        Product kiwi = new FixPriceProduct("Kiwi");

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(mango);
        basket.addProduct(pineapple);
        System.out.println();

        System.out.println("Попытка добавить продукт в заполненную корзину:");
        basket.addProduct(kiwi);
        System.out.println();

        System.out.println("Печать содержимого корзины:");
        basket.printBasket();
        System.out.println();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println();

        System.out.println("Поиск товара 'Banana' в корзине:");
        System.out.println("Есть ли в корзине Banana? " + basket.containsProduct("Banana"));
        System.out.println();

        System.out.println("Поиск товара 'Kiwi' в корзине:");
        System.out.println("Есть ли в корзине Kiwi? " + basket.containsProduct("Kiwi"));
        System.out.println();

        System.out.println("Очистка корзины:");
        basket.clearBasket();
        System.out.println();

        System.out.println("Печать содержимого пустой корзины:");
        basket.printBasket();
        System.out.println();

        System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println();

        System.out.println("Поиск товара 'Apple' в пустой корзине:");
        System.out.println("Есть ли в корзине Apple? " + basket.containsProduct("Apple"));
    }
}
