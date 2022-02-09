package by.tms2022.util;

import by.tms2022.module.Book;
import by.tms2022.module.FullNameReader;
import by.tms2022.module.Reader;


public class LibraryCreator {
    public static Reader[] createReader() {
        Reader[] readers = new Reader[5];
        readers[0] = new Reader(new FullNameReader("Ivan", "Ivanov", "Ivanovich"), 1, "Исторический", "20.10.2001", "12345");
        readers[1] = new Reader(new FullNameReader("Sergey", "Sergeev", "Sergeevich"), 2, "Математический", "19.12.2001", "56783");
        readers[2] = new Reader(new FullNameReader("Petr", "Petrov", "Petrovich"), 3, "Физический", "02.07.2002", "45679");
        readers[3] = new Reader(new FullNameReader("Aleksandr", "Aleksandrov", "Aleksandrovich"), 4, "Биологический", "11.06.2001", "13483");
        readers[4] = new Reader(new FullNameReader("Sidr", "Sidorov", "Sidorovich"), 5, "Исторический", "21.05.2003", "564321");
        return readers;
    }

    public static Book[] createBooks() {
        Book[] books = new Book[5];
        books[0] = new Book("Словарь", "Даль");
        books[1] = new Book("Стихи", "Пушкин");
        books[2] = new Book("Басни", "Крылов");
        books[3] = new Book("Музыка", "Глинка");
        books[3] = new Book("История", "Тарле");
        return books;
    }


}
