package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Map<String, SearchStrategy> STRATEGY_MAP = Map.of(
            "ALL", new AllStrategy(),
            "ANY", new AnyStrategy(),
            "NONE", new NoneStrategy()
    );

    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        Map<String, List<Integer>> wordMap = new HashMap<>();
        File file = new File(args[1]);
        Scanner scanner = new Scanner(System.in);
        List<String> strings = readStrings(wordMap, file);

        while (true) {
            String command = chooseCommand(scanner);
            System.out.println();
            switch (command) {
                case "1":
                    findStrings(wordMap, strings, scanner, searcher);
                    break;
                case "2":
                    printAll(strings);
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Incorrect option! Try again.");
                    System.out.println();
                    break;
            }
        }
    }

    private static void findStrings(Map<String, List<Integer>> wordMap, List<String> strings,
                                    Scanner scanner, Searcher searcher) {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String strategyInput = scanner.nextLine();

        SearchStrategy strategy = STRATEGY_MAP.get(strategyInput);

        if (strategy == null) {
            System.out.println("Wrong input, try again");
            return;
        }

        searcher.setStrategy(strategy);
        searcher.search(strings, wordMap, scanner);
    }

    private static void printAll(List<String> strings) {
        System.out.println("=== List of strings ===");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
    }

    private static String chooseCommand(Scanner scanner) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
        return scanner.nextLine();
    }

    private static List<String> readStrings(Map<String, List<Integer>> wordMap, File file) {
        List<String> result = new ArrayList<>();
        int index = 0;
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String input = fileScanner.nextLine();
                result.add(input);
                String[] inputWords = input.split(" ");
                for (String word : inputWords) {
                    wordMap.computeIfAbsent(word.toLowerCase(), k -> new ArrayList<>()).add(index);
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
