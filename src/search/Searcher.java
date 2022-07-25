package search;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Searcher {

    private SearchStrategy strategy;

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void search(List<String> strings, Map<String, List<Integer>> wordMap, Scanner scanner) {
        System.out.println("Enter data to search string:");
        String stringToFind = scanner.nextLine();
        Set<String> result = strategy.findWord(strings, stringToFind, wordMap);
        if (result.size() == 0) {
            System.out.println("No matching strings found");
            return;
        }

        for (String string : result) {
            System.out.println(string);
        }
        System.out.println();
    }
}
