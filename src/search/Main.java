package search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordMap = new HashMap<>();

        readWords(wordMap, scanner);
        String stringToFind = scanner.nextLine();
        findWord(wordMap, stringToFind);
    }

    private static void findWord(Map<String, Integer> wordMap, String stringToFind) {
        if (!wordMap.containsKey(stringToFind)) {
            System.out.println("Not found");
            return;
        }

        System.out.println(wordMap.get(stringToFind));
    }

    private static void readWords(Map<String, Integer> wordMap, Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            wordMap.put(input[i], i + 1);
        }
    }
}
