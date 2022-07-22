package search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        readStrings(strings, scanner);
        System.out.println("Enter the number of search queries");
        int queries = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < queries; i++) {
            System.out.println("Enter data to search string:");
            String stringToFind = scanner.nextLine();
            findWord(strings, stringToFind);
        }
    }

    private static void findWord(List<String> strings, String stringToFind) {
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            if (string.toLowerCase().contains(stringToFind.toLowerCase())) {
                result.add(string);
            }
        }
        if (result == null) {
            System.out.println("No matching string found.");
        } else {
            System.out.println();
            System.out.println("Found strings:");
            for (String string : result) {
                System.out.println(string);
            }
        }
        System.out.println();
    }

    private static void readStrings(List<String> strings, Scanner scanner) {
        System.out.println("Enter the number of strings");
        int number = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        System.out.println("Enter all strings");
        for (int i = 0; i < number; i++) {
            strings.add(scanner.nextLine());
        }
        System.out.println();
    }
}
