// Assignment Question:
// **Assignment Question:**

Create a Java program to manage a library's book collection. The program should handle the following operations:

- Add a new book to the collection with title, author, and year of publication.
- Remove a book from the collection based on its title.
- Display all books in the collection, sorted alphabetically by title.
- Search for a book by author or by year of publication.
- Find the book with the most recent year of publication.

Use an array to store the book data and apply string handling techniques to manage the book titles and perform searches. Implement the above operations as methods within a `LibraryManager` class.
// Author: Ansh Pandey

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManager {

    private Book[] books;
    private int numBooks;

    public LibraryManager(Book[] books) {
        this.books = books;
        numBooks = books.length;
    }

    public void addBook(String title, String author, int year) {
        if (numBooks < books.length) {
            Book book = new Book(title, author, year);
            books[numBooks++] = book;
            Arrays.sort(books, 0, numBooks, Comparator.comparing(Book::getTitle));
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    public void removeBook(String title) {
        int removeIndex = -1;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getTitle().equals(title)) {
                removeIndex = i;
                break;
            }
        }
        if (removeIndex != -1) {
            for (int i = removeIndex; i < numBooks - 1; i++) {
                books[i] = books[i + 1];
            }
            numBooks--;
            Arrays.sort(books, 0, numBooks, Comparator.comparing(Book::getTitle));
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    public void displayBooks() {
        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i].toString());
        }
    }

    public void searchBookByAuthor(String author) {
        int found = 0;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getAuthor().equals(author)) {
                System.out.println(books[i].toString());
                found++;
            }
        }
        if (found == 0) {
            System.out.println("No books found by this author.");
        }
    }

    public void searchBookByYear(int year) {
        int found = 0;
        for (int i = 0; i < numBooks; i++) {
            if (books[i].getYear() == year) {
                System.out.println(books[i].toString());
                found++;
            }
        }
        if (found == 0) {
            System.out.println("No books found by this publication year.");
        }
    }

    public void findMostRecentBook() {
        if (numBooks > 0) {
            Book mostRecent = Arrays.stream(books, 0, numBooks)
                    .max(Comparator.comparing(Book::getYear))
                    .orElse(null);
            System.out.println("The book with the most recent year of publication is:");
            System.out.println(mostRecent.toString());
        } else {
            System.out.println("No books found in the library.");
        }
    }

    public static class Book {
        private String title;
        private String author;
        private int year;

        public Book(String title, String author, int year) {
            this.title = title;
            this.author = author;
            this.year = year;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Title: " + title + ", Author: " + author + ", Year: " + year;
        }
    }

    public static void main(String[] args) {
        Book[] books = new Book[5];
        LibraryManager libraryManager = new LibraryManager(books);
        libraryManager.addBook("Book A", "Author A", 2010);
        libraryManager.addBook("Book B", "Author B", 2015);
        libraryManager.addBook("Book C", "Author A", 2020);

        libraryManager.displayBooks();

        libraryManager.searchBookByAuthor("Author A");

        libraryManager.searchBookByYear(2015);

        libraryManager.removeBook("Book A");

        libraryManager.displayBooks();

        libraryManager.findMostRecentBook();
    }
}
This program creates a `LibraryManager` class that manages a collection of books. It provides methods to add books, remove books, display books, search for books by author or year, and find the most recent book. The `Book` class represents a single book with a title, author, and year. The program also includes a `main` method to demonstrate the usage of the `LibraryManager` class.