package Modul_2;
import java.util.Scanner;

class Main {
    public static Book[] bookList = {
            new Book(1, "Harry Potter", "J.K. Rowling", 10),
            new Book(2, "LOL", "J.R.R. Tolkien", 8),
            new Book(3, "Tes", "Tes", 12)
    };

    public static User[] userStudent = {
            new Student("Moon", "123456789012345"),
            new Student("Zacky", "202310370311254")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("====Library System====");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Student");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginMahasiswa();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
        scanner.close();
    }

    private static void loginAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (username.equals("admin") && password.equals("adm")) {
            System.out.println("Login as Admin successful!");
            menuAdmin();
        } else {
            System.out.println("Login failed! Incorrect username or password.");
        }
    }

    private static void loginMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter NIM: ");
        String nim = scanner.next();

        if (nim.length() != 15) {
            System.out.println("NIM must be 15 characters long!");
        } else {
            System.out.println("Login as Student successful!");
            menuStudent();
        }
    }

    private static void menuAdmin() {
        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n====Admin Menu====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    admin.addStudent();
                    break;
                case 2:
                    admin.displayStudent();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void menuStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        int choice;
        do {
            System.out.println("\n====Student Menu====");
            System.out.println("1. Buku Terpinjam");
            System.out.println("2. Pinjam Buku");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    student.displayBorrowedBooks();
                    break;
                case 2:
                    student.displayBooks();
                    student.borrowBook();
                    break;
                case 3:
                    student.logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}

class Book {
    int id;
    String title;
    String author;
    int stock;

    public Book(int id, String title, String author, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
}

class User {
    protected String name;
    protected String nim;

    public User(String name, String nim) {
        this.name = name;
        this.nim = nim;
    }
}


