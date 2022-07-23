package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Map<String, List<Integer>> wordMap = new HashMap<>();
        File file = new File(args[1]);
        Scanner scanner = new Scanner(System.in);
        try (Scanner fileScanner = new Scanner(file)) {
            readStrings(strings, wordMap, fileScanner);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            String command = chooseCommand(scanner);
            System.out.println();
            switch (command) {
                case "1":
                    search(strings, wordMap, scanner);
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

    private static void printAll(List<String> strings) {
        System.out.println("=== List of strings ===");
        for (String string : strings) {
            System.out.println(string);
        }
        System.out.println();
    }

    private static void search(List<String> strings, Map<String, List<Integer>> wordMap, Scanner scanner) {
        System.out.println("Enter data to search string:");
        String stringToFind = scanner.nextLine();
        findWord(strings, wordMap, stringToFind);
    }

    private static String chooseCommand(Scanner scanner) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
        return scanner.nextLine();
    }


    private static void findWord(List<String> strings, Map<String, List<Integer>> wordMap, String stringToFind) {
        List<Integer> result = wordMap.getOrDefault(stringToFind, Collections.emptyList());
        if (result.size() == 0) {
            System.out.println("No matching string found.");
        } else {
            for (Integer index : result) {
                System.out.println(strings.get(index));
            }
        }
        System.out.println();
    }

    private static void readStrings(List<String> strings, Map<String, List<Integer>> wordMap, Scanner scanner) {
        int index = 0;
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            strings.add(input);
            String[] inputWords = input.split(" ");
            for (String word : inputWords) {
                wordMap.computeIfAbsent(word, k -> new ArrayList<>()).add(index);
            }
            index++;
        }
    }
}
