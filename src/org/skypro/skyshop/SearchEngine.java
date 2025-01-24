package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

        public SearchEngine(int capacity) {
            this.searchables = new Searchable[capacity];
        }

        public void add(Searchable searchable) {
            if (count < searchables.length) {
                searchables[count] = searchable;
                count++;
            } else {
                System.out.println("Невозможно добавить элемент: поисковый движок заполнен.");
            }
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
    }


