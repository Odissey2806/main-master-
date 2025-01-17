package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Product apple = new SimpleProduct("Apple", 50);
        Product banana = new DiscountedProduct("Banana", 30,10);
        Product orange = new FixPriceProduct("Orange");
        Product mango = new SimpleProduct("Mango", 60);
        Product pineapple = new DiscountedProduct("Pineapple", 70,20);
        Product kiwi = new FixPriceProduct("Kiwi");

        Article appleArticle = new Article("Apple Benefits", "Apples are rich in fiber and vitamins.");
        Article bananaArticle = new Article("Banana Facts", "Bananas are a great source of potassium.");

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
    }
}
