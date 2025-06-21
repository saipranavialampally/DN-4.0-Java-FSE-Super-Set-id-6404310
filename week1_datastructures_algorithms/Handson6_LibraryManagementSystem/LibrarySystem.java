package week1_datastructures_algorithms.Handson6_LibraryManagementSystem;

import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySystem {

    // Linear search for book title
    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = books[mid].title.compareToIgnoreCase(targetTitle);

            if (comparison == 0)
                return books[mid];
            else if (comparison < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(101, "The Alchemist", "Paulo Coelho"),
                new Book(102, "Harry Potter", "J.K Rowling"),
                new Book(103, "Rich Dad Poor Dad", "Robert Kiyosaki")
        };

        System.out.println("Linear Search:");
        Book found1 = linearSearch(books, "Harry Potter");
        if (found1 != null)
            System.out.println(found1.title + " by " + found1.author);
        else
            System.out.println("Not Found");

        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\nBinary Search:");
        Book found2 = binarySearch(books, "Harry Potter");
        if (found2 != null)
            System.out.println(found2.title + " by " + found2.author);
        else
            System.out.println("Not Found");
    }
}
