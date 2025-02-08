package org.skypro.skyshop;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public List<Searchable> findAllMatches(String search) throws BestResultNotFound {
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

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query)) {
                results[foundCount] = searchable;
                foundCount++;
                if (foundCount == 5) {
                    break;
                }
            }
        }

        return results;
    }

    private int countOccurrences(String str, String substring) {
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
