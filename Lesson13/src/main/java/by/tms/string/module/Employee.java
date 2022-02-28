package by.tms.string.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Employee implements Report {
    private String fullname;
    private double salary;

    @Override
    public void generateReport() {
        String delimeter = " ";
        String[] subStr = fullname.split(delimeter);
        String name = subStr[0].substring(0, 1) + "." + subStr[1].substring(0, 1) + "." + subStr[2];
        String formatName = String.format("%-15s", name);
        String formatSalary = String.format("%15s", String.format("%.2f", salary));
        System.out.println("|" + formatName + "|" + formatSalary + "|");
    }
}

