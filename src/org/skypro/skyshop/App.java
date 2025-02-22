package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        try {
            Product invalidProduct = new SimpleProduct("", 50);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product invalidPriceProduct = new SimpleProduct("Invalid Price", -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product invalidDiscountProduct = new DiscountedProduct("Invalid Discount", 50, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        Product apple = new SimpleProduct("Apple", 50);
        Product banana = new DiscountedProduct("Banana", 30, 10);
        Product orange = new FixPriceProduct("Orange");
        Product mango = new SimpleProduct("Mango", 60);
        Product pineapple = new DiscountedProduct("Pineapple", 70, 20);
        Product kiwi = new FixPriceProduct("Kiwi");

        Article appleArticle = new Article("Apple Benefits", "Apples are rich in fiber and vitamins.");
        Article bananaArticle = new Article("Banana Facts", "Bananas are a great source of potassium.");

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.add(apple);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(mango);
        searchEngine.add(pineapple);
        searchEngine.add(kiwi);
        searchEngine.add(appleArticle);
        searchEngine.add(bananaArticle);

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Apple");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("Grape");
            System.out.println("Найден лучший результат: " + bestMatch.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        ProductBasket basket = new ProductBasket();

        System.out.println("\nДобавление продуктов в корзину:");
        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(mango);
        basket.addProduct(pineapple);
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

        List<Product> removedProducts = basket.removeProductByName("Apple");
        System.out.println("\nУдаление продуктов по имени:");
        for (Product product : removedProducts) {
            System.out.println(product);
        }

        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasket();

        List<Product> emptyList = basket.removeProductByName("Grape");
        if (emptyList.isEmpty()) {
            System.out.println("\nСписок удаленных продуктов пуст.");
        }

        System.out.println("\nСодержимое корзины:");
        basket.printBasket();

        System.out.println("\nРезультаты поиска по запросу 'Apple':");
        TreeSet<Searchable> searchResults = searchEngine.search("Apple");
        for (Searchable result : searchResults) {
            System.out.println(result.getName() + " — " + result.getStringRepresentation());
        }
    }
}