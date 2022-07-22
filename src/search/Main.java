package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        readStrings(strings, scanner);

        while (true) {
            String command = chooseCommand(scanner);
            System.out.println();
            switch (command) {
                case "1":
                    search(strings, scanner);
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

    private static void search(List<String> strings, Scanner scanner) {
        System.out.println("Enter data to search string:");
        String stringToFind = scanner.nextLine();
        findWord(strings, stringToFind);
    }

    private static String chooseCommand(Scanner scanner) {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
        return scanner.nextLine();
    }


    private static void findWord(List<String> strings, String stringToFind) {
        List<String> result = new ArrayList<>();
        for (String string : strings) {
            if (string.toLowerCase().contains(stringToFind.toLowerCase())) {
                result.add(string);
            }
        }
        if (result.size() == 0) {
            System.out.println("No matching string found.");
        } else {
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
        System.out.println("Enter all strings");
        for (int i = 0; i < number; i++) {
            strings.add(scanner.nextLine());
        }
        System.out.println();
    }
}
