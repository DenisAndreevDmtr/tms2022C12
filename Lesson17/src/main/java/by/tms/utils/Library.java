package by.tms.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class Library {
    private List<Book> books;
    private List<Reader> readers;

    public List<Book> getAllBooksInLibrarySortedByYear() {
        List<Book> sortedList = books.stream()
                .sorted(Comparator.comparing(Book::getYear))
                .collect(Collectors.toList());
        return sortedList;
    }

    public List<EmailAdress> getAllEmailAdressOfReaders() {
        List<EmailAdress> listOfEmails = readers.stream()
                .map(x -> x.getEmail())
                .collect(Collectors.toList());
        return listOfEmails;
    }

    public List<EmailAdress> getAllEmailAdressOfReadersThatAceeptedMailing() {
        List<EmailAdress> listOfEmails = readers.stream()
                .filter(x -> x.isAgreementMail() == true)
                .map(x -> x.getEmail())
                .collect(Collectors.toList());
        return listOfEmails;
    }

    public boolean checkReadersHaveTookBookOfAuthor(String str) {
        return readers.stream().map(Reader::getBookList).flatMap(Collection::stream).anyMatch(x -> x.getAuthor().equals(str));
    }

    public String getMaxNumberOfBooksThatReaderHas() {
        int count = 0;
        List<Integer> numbers = readers.stream()
                .map(Reader::getBookList)
                .map(x -> x.size())
                .collect(Collectors.toList());
        List<Integer> sortedNumbers = numbers.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        return "Наибольшее количество книг у одного читателя " + sortedNumbers.get(0);
    }

    public Map<String, List<Reader>> getTwoGroupsForReaders() {
        Map<String, List<Reader>> groups = new HashMap<>();
        groups.put("OK", readersThatHaveLessThenTwoBooks());
        groups.put("TOO_MUCH", readersThatHaveMoreThenTwoBooks());

        return groups;
    }

    public Map<String, List<EmailAdress>> getMailingTwoGroups() {
        Map<String, List<EmailAdress>> email = new HashMap<>();
        email.put("OK", readersThatHaveLessThenTwoBooks().stream().map(Reader::getEmail).collect(Collectors.toList()));
        email.put("TOO_MUCH", readersThatHaveLessThenTwoBooks().stream().map(Reader::getEmail).collect(Collectors.toList()));

        return email;
    }

    public Map<String, List<String>> getNameSurnamePatronymic() {
        Map<String, List<String>> groups = new HashMap<>();
        groups.put("OK", readersThatHaveLessThenTwoBooks().stream().map(x -> getReaderInfro(x)).collect(Collectors.toList()));
        groups.put("TOO_MUCH", readersThatHaveMoreThenTwoBooks().stream().map(x -> getReaderInfro(x)).collect(Collectors.toList()));

        return groups;
    }

    private List<Reader> readersThatHaveLessThenTwoBooks() {
        return readers.stream().filter(x -> !x.checkReaderTookMoreThenTwoBooks()).collect(Collectors.toList());
    }

    private List<Reader> readersThatHaveMoreThenTwoBooks() {
        return readers
                .stream()
                .filter(x -> x.checkReaderTookMoreThenTwoBooks())
                .collect(Collectors.toList());
    }

    private String getReaderInfro(Reader r) {
        return r.getName() + " " + r.getSurname() + " " + r.getSurname();
    }


}