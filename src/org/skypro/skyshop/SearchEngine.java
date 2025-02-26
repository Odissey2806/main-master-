package org.skypro.skyshop;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine(int capacity) {
        this.searchables = new ArrayList<>(capacity);
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int count = countOccurrences(searchable.getSearchTerm(), search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }

        return bestMatch;
    }

    public TreeSet<Searchable> search(String query) {
        return searchables.stream()
                .filter(Objects::nonNull)
                .filter(searchable -> searchable.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    private int countOccurrences(String str, String substring) {
        if (str == null || substring == null || substring.isEmpty()) {
            return 0;
        }

        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substringLength;
        }

        return count;
    }
}