package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

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
