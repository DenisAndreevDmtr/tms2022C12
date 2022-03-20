package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString

public class Reader {
    private String surname;
    private String name;
    private String patronymic;
    private EmailAdress email;
    private boolean agreementMail;
    private List<Book> bookList;

    public boolean checkReaderTookMoreThenTwoBooks() {
        if (bookList.size() >= 2) {
            return true;
        } else {
            return false;
        }
    }

}
