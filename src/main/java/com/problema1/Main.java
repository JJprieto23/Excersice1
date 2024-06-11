package com.problema1;

import com.problema1.entity.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = getChoice();
            handleChoice(choice);
        }
    }

    private static void showMenu() {
        System.out.println("----- Sistema de Gestión de Biblioteca -----");
        System.out.println("1. Agregar libro");
        System.out.println("2. Buscar libro por título");
        System.out.println("3. Buscar libro por autor");
        System.out.println("4. Mostrar todos los libros");
        System.out.println("5. Prestar libro");
        System.out.println("6. Devolver libro");
        System.out.println("7. Salir");
        System.out.print("Elige una opción: ");
    }

    private static int getChoice() {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, ingresa un número.");
        }
        return choice;
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                searchBookByTitle();
                break;
            case 3:
                searchBookByAuthor();
                break;
            case 4:
                showAllBooks();
                break;
            case 5:
                borrowBook();
                break;
            case 6:
                returnBook();
                break;
            case 7:
                System.out.println("Saliendo del sistema. ¡Adiós!");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida. Por favor, intenta de nuevo.");
        }
    }

    private static void addBook() {
        try {
            System.out.print("Título: ");
            String title = scanner.nextLine();
            System.out.print("Autor: ");
            String author = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Año de publicación: ");
            int publicationYear = Integer.parseInt(scanner.nextLine());

            Book book = new Book(title, author, isbn, publicationYear);
            library.addBook(book);
            System.out.println("Libro agregado exitosamente.");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. El año de publicación debe ser un número.");
        }
    }

    private static void searchBookByTitle() {
        System.out.print("Título: ");
        String title = scanner.nextLine();
        ArrayList<Book> results = library.searchBooksByTitle(title);
        if (results.isEmpty()) {
            System.out.println("No se encontraron libros con el título especificado.");
        } else {
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private static void searchBookByAuthor() {
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        ArrayList<Book> results = library.searchBooksByAuthor(author);
        if (results.isEmpty()) {
            System.out.println("No se encontraron libros con el autor especificado.");
        } else {
            for (Book book : results) {
                System.out.println(book);
            }
        }
    }

    private static void showAllBooks() {
        ArrayList<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No hay libros disponibles en la biblioteca.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private static void borrowBook() {
        System.out.print("ISBN del libro a prestar: ");
        String isbn = scanner.nextLine();
        Book book = library.getBookByIsbn(isbn);
        if (book == null) {
            System.out.println("No se encontró un libro con el ISBN especificado.");
        } else if (book.isBorrowed()) {
            System.out.println("El libro ya está prestado.");
        } else {
            book.borrowBook();
            System.out.println("Libro prestado exitosamente.");
        }
    }

    private static void returnBook() {
        System.out.print("ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();
        Book book = library.getBookByIsbn(isbn);
        if (book == null) {
            System.out.println("No se encontró un libro con el ISBN especificado.");
        } else if (!book.isBorrowed()) {
            System.out.println("El libro no está prestado.");
        } else {
            book.returnBook();
            System.out.println("Libro devuelto exitosamente.");
        }
    }
}
