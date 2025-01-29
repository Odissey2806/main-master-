package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        //       Product apple = new SimpleProduct("Apple", 50);
        //       Product banana = new DiscountedProduct("Banana", 30,10);
        //       Product orange = new FixPriceProduct("Orange");
        //       Product mango = new SimpleProduct("Mango", 60);
        //       Product pineapple = new DiscountedProduct("Pineapple", 70,20);
        //       Product kiwi = new FixPriceProduct("Kiwi");

        ProductBasket basket = new ProductBasket();

        System.out.println("Добавление продуктов в корзину:");
        basket.addProduct(new SimpleProduct("Apple", 50));
        basket.addProduct(new DiscountedProduct("Banana", 30, 10));
        basket.addProduct(new SimpleProduct("Apple", 50));
        //       basket.addProduct(orange);
        //       basket.addProduct(mango);
        //       basket.addProduct(pineapple);
        //       System.out.println();

        //       System.out.println("Попытка добавить продукт в заполненную корзину:");
        //       basket.addProduct(kiwi);
        //       System.out.println();

        //      System.out.println("Печать содержимого корзины:");
//        basket.printBasket();
        //      System.out.println();

        //      System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        //      System.out.println();

        //      System.out.println("Поиск товара 'Banana' в корзине:");
        //      System.out.println("Есть ли в корзине Banana? " + basket.containsProduct("Banana"));
        //       System.out.println();

        //       System.out.println("Поиск товара 'Kiwi' в корзине:");
        //       System.out.println();

        //       System.out.println("Очистка корзины:");
        //       basket.clearBasket();
        //       System.out.println();

        System.out.println("Печать содержимого пустой корзины:");
        basket.printBasket();
        System.out.println();

        //      System.out.println("Общая стоимость пустой корзины: " + basket.getTotalCost());
        //      System.out.println();

        //       System.out.println("Поиск товара 'Apple' в пустой корзине:");
        //      System.out.println("Есть ли в корзине Apple? " + basket.containsProduct("Apple"));
        List<Product> removedProducts = basket.removeProductByName("Apple");
        System.out.println("Удаление продуктов по имени");
        for (Product product : removedProducts) {
            System.out.println(product);
        }

        System.out.println("Выводим содержимое корзины после удаления");
        basket.printBasket();

        List<Product> emptyList = basket.removeProductByName("Grape");
        if (emptyList.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст.");
        }

        System.out.println("Содержимое корзины");
        basket.printBasket();
    }
}
