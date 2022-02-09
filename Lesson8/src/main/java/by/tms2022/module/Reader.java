package by.tms2022.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
@Setter
public class Reader {
    private FullNameReader fullName;
    private int numberLibraryCard;
    private String department;
    private String dateBirth;
    private String telNumber;


    public String takeBook(String... books) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " взял книги " + convertArrayIntoString(books);
    }

    public String takeBook(int count) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " взял " + count + " книги ";
    }

    public String takeBook(Book... books) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " взял книги " + convertBooksIntoStringName(books);
    }

    public String returnBook(String... books) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " вернул книги " + convertArrayIntoString(books);
    }

    public String returnBook(int count) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " вернул " + count + " книги ";
    }

    public String returnBook(Book... books) {
        return "Пользователь " + fullName.getSurname() + " " + fullName.getName() + " " + fullName.getPatronymic() + " вернул книги " + convertBooksIntoStringName(books);
    }

    private String convertBooksIntoStringName(Book[] books) {
        String[] mas = new String[books.length];
        for (int i = 0; i < books.length; i++) {
            mas[i] = books[i].getName();
        }
        String namebooks = convertArrayIntoString(mas);
        return namebooks;
    }


    private String convertArrayIntoString(String[] smth) {
        String books = Arrays.toString(smth);
        return books;
    }


    @Override
    public String toString() {
        return "Reader{" +
                "Имя='" + fullName.getName() +
                "Фамилия='" + fullName.getSurname() +
                "Отчество='" + fullName.getPatronymic() +
                ", numberLibraryCard=" + numberLibraryCard +
                ", department='" + department + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
