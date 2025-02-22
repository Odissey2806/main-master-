package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "Продукт";
    }

    @Override
    public String getStringRepresentation() {
        return name + " - " + price + " руб.";
    }

    public abstract boolean isSpecial();
}