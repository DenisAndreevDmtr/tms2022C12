package by.tms.string.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StringMas {

    private StringLine[] stringLines;

    //3) В массиве находятся слова. Вывести на экран слова палиндромы
    public StringBuilder getAllPalindromes() {
        StringBuilder palindromes = new StringBuilder();
        for (int i = 0; i < stringLines.length; i++) {
            StringBuilder stringBuilder = new StringBuilder(stringLines[i].getStringName());
            StringBuilder reverseStr = stringBuilder.reverse();
            if (stringLines[i].getStringName().equalsIgnoreCase(reverseStr.toString())) {
                palindromes.append(stringLines[i].getStringName() + " ");
            }
        }
        return palindromes;
    }

}
