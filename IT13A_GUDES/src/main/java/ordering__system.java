
package Midterm;

import java.io.*;
import java.util.Scanner;

public class ordering__system{
    static final String FILE_NAME = "C:\\midtermdata\\For Midterm Project.txt";
    static final int SHIFT = 3;

    static String[] foodItems = {
        "Beef Steak", "Ground Beef", "Beef Ribs", "Pork Chop",
        "Ground Pork", "Pork Belly"
    };

    static double[] foodPrices = {
       350.0, 280.0, 400.0, 250.0, 220.0, 300.0
    };

    static int[] quantities = new int[foodItems.length];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Welcome to karne ===");

        while (true) {
            System.out.println("\n[1] Create Account\n[2] Login\n[3] Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                createAccount(scanner);
            } else if (choice == 2) {
                if (login(scanner)) {
                    orderFood(scanner);
                }
            } else if (choice == 3) {
                System.out.println("Paalam,labyu!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }

    // Para sa Account
    static void createAccount(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String encrypted = encrypt(password);

        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(username + "," + encrypted + "\n");
            System.out.println("Account created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Login
    static boolean login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    String decrypted = decrypt(parts[1]);
                    if (decrypted.equals(password)) {
                        System.out.println("Login successful!");
                        return true;
                    } else {
                        System.out.println("Incorrect password.");
                        return false;
                    }
                }
            }
            System.out.println("User not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
        return false;
    }

    // Ordering system
    static void orderFood(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--- MENU ---");
            for (int i = 0; i < foodItems.length; i++) {
                System.out.printf("[%d] %s - Php%.2f\n", i + 1, foodItems[i], foodPrices[i]);
            }
            System.out.println("[0] Exit and Show Summary");

            System.out.print("Choose an item: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= foodItems.length) {
                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                quantities[choice - 1] += qty;
            } else if (choice != 0) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 0);

        showSummary();
    }

    // Order summary
    static void showSummary() {
        float total = 0;
        System.out.println("\n=== Order Summary ===");
        for (int i = 0; i < foodItems.length; i++) {
            if (quantities[i] > 0) {
                double itemTotal = quantities[i] * foodPrices[i];
                total += itemTotal;
                System.out.printf("%s x%d = Php%.2f\n", foodItems[i], quantities[i], itemTotal);
            }
        }
        System.out.printf("TOTAL BILL: Php%.2f\n", total);
        System.out.println("======================");
    }

    // Caesar Cipher Encryption
    static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char)(c + SHIFT));
        }
        return sb.toString();
    }

    // Caesar Cipher Decryption
    static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char)(c - SHIFT));
        }
        return sb.toString();
    }
}