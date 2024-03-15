package Modul_2;
import java.util.Scanner;

class Admin {
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAdding Student");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter NIM: ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Invalid NIM length. NIM must be 15 characters long.");
            return;
        }

        System.out.println("Student added successfully.");
    }

    public void displayStudent() {
        System.out.println("\nList of Registered Students:");
        System.out.println("Name | NIM");
        for (User user : Main.userStudent) {
            System.out.println(user.name + " | " + user.nim);
        }
    }
}