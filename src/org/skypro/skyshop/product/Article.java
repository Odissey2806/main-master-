package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public final class Article implements Searchable {
        private final String title;
        private final String content;

        public Article(String title, String content) {
            this.title = title;
            this.content = content;
        }

        @Override
        public String getSearchTerm() {
            return toString();
        }

        @Override
        public String getContentType() {
        return "ARTICLE";
        }

        public String getName() {
            return title;
        }

        @Override
        public String toString() {
            return title + "\n" + content;
        }
    }



