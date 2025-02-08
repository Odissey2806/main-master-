package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> findBestMatch(String search) throws BestResultNotFound {
        List<Searchable> matches = new ArrayList<>();
        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(search)) {
                matches.add(searchable);
            }
        }
        if (matches.isEmpty()) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }
        return matches;
    }
}
