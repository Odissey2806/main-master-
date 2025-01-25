package org.skypro.skyshop;


import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Article;


import org.skypro.skyshop.SearchEngine;
import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.BestResultNotFound;

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


        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new SimpleProduct("Apple", 50));
        searchEngine.add(new Article("Apple Benefits", "Apples are rich in fiber and vitamins."));
        searchEngine.add(new DiscountedProduct("Banana", 30, 10));


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
    }
}