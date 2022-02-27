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
        String delimeter = "\\ ";
        String[] subStr;
        subStr = fullname.split(delimeter);
        System.out.println(String.format("|" + String.format("%-15s", subStr[0].substring(0, 1) + "." + subStr[1].substring(0, 1) + "." + subStr[2]) + "|" + "%15s" + "|", String.format("%.2f", salary)));
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullname='" + fullname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
