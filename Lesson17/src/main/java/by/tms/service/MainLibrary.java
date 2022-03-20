package by.tms.service;

import by.tms.module.Book;
import by.tms.module.EmailAdress;
import by.tms.module.Library;
import by.tms.module.Reader;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MainLibrary {
    public static void main(String[] args) {
        Book book1 = new Book("Лев Николаевич Толстой", "Война и мир", 1867);
        Book book2 = new Book("Александр Сергеевич Пушкин", "Евгений Онегин", 1833);
        Book book3 = new Book("Лев Николаевич Толстой", "Кавказкий пленник", 1872);
        Book book4 = new Book("Александр Сергеевич Пушкин", "Борис Годунов", 1831);
        Book book5 = new Book("Михаил Юрьевич Лермонтов", "Герой нашего времени", 1853);
        Book book6 = new Book("Гоголь Николай Васильевич", "Ревизор", 1836);
        List<Book> allBooks = Arrays.asList(book1, book2, book3, book4, book5, book6);
        List<Book> reader1Books = Arrays.asList(book1, book5, book6);
        List<Book> reader2Books = Arrays.asList(book2);
        List<Book> reader3Books = Arrays.asList(book1, book2, book4, book6, book1);
        Reader reader1 = new Reader("Иванов", "Иван", "Петрович", new EmailAdress("ivanov@gmail.com", "reader"), true, reader1Books);
        Reader reader2 = new Reader("Сидоров", "Павел", "Валентинович", new EmailAdress("sidorov@gmail.com", "reader"), false, reader2Books);
        Reader reader3 = new Reader("Петров", "Андрей", "Олегович", new EmailAdress("petrov@gmail.com", "reader"), true, reader3Books);
        List<Reader> allReaders = Arrays.asList(reader1, reader2, reader3);
        Library library = new Library(allBooks, allReaders);
        library.getAllBooksInLibrarySortedByYear();
        library.getAllEmailAdressOfReadersThatAceeptedMailing();
        System.out.println(library.checkReadersHaveTookBookOfAuthor("Александр Сергеевич Пушкин"));
        System.out.println(library.getMaxNumberOfBooksThatReaderHas());
        //library.getMailingTwoGroups();
        for (Map.Entry<String, List<EmailAdress>> str : library.getMailingTwoGroups().entrySet()) {
            System.out.println(str.getKey() + " - " + str.getValue().toString());
        }
        //library.getTwoGroupsForReaders();
        for (Map.Entry<String, List<Reader>> str : library.getTwoGroupsForReaders().entrySet()) {
            System.out.println(str.getKey() + " - " + str.getValue().toString());
        }
        //library.getNameSurnamePatronymic();
        for (Map.Entry<String, List<String>> str : library.getNameSurnamePatronymic().entrySet()) {
            System.out.println(str.getKey() + "{" + str.getValue().toString().replaceAll("^\\[|\\]$", "") + "}");
        }
    }
}
