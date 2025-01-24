package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.article.Article;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // Создание продуктов
        Product apple = new SimpleProduct("Apple", 50);
        Product banana = new DiscountedProduct("Banana", 30, 10);
        Product orange = new FixPriceProduct("Orange");
        Product mango = new SimpleProduct("Mango", 60);
        Product pineapple = new DiscountedProduct("Pineapple", 70, 20);
        Product kiwi = new FixPriceProduct("Kiwi");

        // Создание статей
        Article appleArticle = new Article("Apple Benefits", "Apples are rich in fiber and vitamins.");
        Article bananaArticle = new Article("Banana Facts", "Bananas are a great source of potassium.");

        // Работа с поисковой системой
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(mango);
        searchEngine.add(pineapple);
        searchEngine.add(kiwi);
        searchEngine.add(appleArticle);
        searchEngine.add(bananaArticle);

        System.out.println("Результаты поиска по запросу 'Apple':");
        System.out.println(Arrays.toString(searchEngine.search("Apple")));

        System.out.println("Результаты поиска по запросу 'Banana':");
        System.out.println(Arrays.toString(searchEngine.search("Banana")));

        System.out.println("Результаты поиска по запросу 'Orange':");
        System.out.println(Arrays.toString(searchEngine.search("Orange")));

        // Работа с корзиной
        ProductBasket basket = new ProductBasket();

        System.out.println("\nДобавление продуктов в корзину:");
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