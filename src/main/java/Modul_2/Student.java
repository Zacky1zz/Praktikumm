package Modul_2;

import java.util.Scanner;

class Student extends User {
    private final boolean[] borrowedBooks;

    public Student(String name, String nim) {
        super(name, nim);
        borrowedBooks = new boolean[Main.bookList.length];
    }

    public Student() {
        super("", "");
        borrowedBooks = new boolean[Main.bookList.length];
    }

    public void displayBooks() {
        System.out.println("\nAvailable Books:");
        System.out.println("ID | Title | Author | Stock");
        for (int i = 0; i < Main.bookList.length; i++) {
            Book book = Main.bookList[i];
            System.out.println(book.id + " | " + book.title + " | " + book.author + " | " + book.stock);
        }
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input id buku yang ingin dipinjam: ");
        int bookId = scanner.nextInt();
        if (bookId < 1 || bookId > Main.bookList.length) {
            System.out.println("Invalid book ID.");
            return;
        }
        Book book = Main.bookList[bookId - 1];
        if (book.stock <= 0) {
            System.out.println("Sorry, this book is currently out of stock.");
        } else if (borrowedBooks[bookId - 1]) {
            System.out.println("You have already borrowed this book.");
        } else {
            borrowedBooks[bookId - 1] = true;
            book.stock--;
            System.out.println("You have successfully borrowed the book: " + book.title);
        }
    }

    public void displayBorrowedBooks() {
        System.out.println("\nBooks Borrowed by You:");
        System.out.println("ID | Title | Author");
        for (int i = 0; i < borrowedBooks.length; i++) {
            if (borrowedBooks[i]) {
                Book book = Main.bookList[i];
                System.out.println(book.id + " | " + book.title + " | " + book.author);
            }
        }
    }

    public void logout() {
        System.out.println("Logging out as Student...");
    }
}

