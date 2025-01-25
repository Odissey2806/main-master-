package org.skypro.skyshop; // Пакет должен быть указан

public interface Searchable {
    String getSearchTerm();
    String getContentType();
    String getName();
    default String getStringRepresentation() {
        return getName() + " — " + getContentType();
    }
}