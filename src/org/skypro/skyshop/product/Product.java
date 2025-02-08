package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable{
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name) {
        this.name = name;
        this.price = 0;
    }

    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

    @Override
    public String getStringRepresentation() {
        return name + " - " + price + " руб.";
    }

    @Override
    public String getContentType() {
        return "Продукт";
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    public abstract boolean isSpecial();
}

