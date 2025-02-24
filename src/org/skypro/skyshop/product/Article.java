package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
        return title + " " + content;
    }

    @Override
    public String getContentType() {
        return "Статья";
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
        return title + ": " + content;
    }
}