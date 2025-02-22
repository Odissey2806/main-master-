package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

    private final String title;
    private final String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getSearchTerm() {
    }

    @Override
    public String getContentType() {
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String toString() {
    }
}
