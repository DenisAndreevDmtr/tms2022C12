package by.tms2022.service;

import by.tms2022.module.Book;
import by.tms2022.module.Reader;
import by.tms2022.util.LibraryCreator;

public class MainLibrary {
    public static void main(String[] args) {
        Reader[] readers = LibraryCreator.createReader();
        Book[] books = LibraryCreator.createBooks();

        System.out.println(readers[3].takeBook("Энциклопедия", "История"));
        System.out.println(readers[0].takeBook(4));
        System.out.println(readers[4].takeBook(books[0], books[3]));
        System.out.println(readers[3].returnBook("Энциклопедия", "История"));
        System.out.println(readers[0].returnBook(4));
        System.out.println(readers[4].returnBook(books[0], books[3]));
    }
}
