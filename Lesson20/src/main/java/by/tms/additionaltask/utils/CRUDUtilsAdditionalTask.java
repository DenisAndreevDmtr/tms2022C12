package by.tms.additionaltask.utils;

import by.tms.additionaltask.module.City;
import by.tms.additionaltask.module.Student;
import by.tms.additionaltask.module.StudentWithCity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtilsAdditionalTask {
    private static final String GET_ALL_STUDENTS_QUERY = "SELECT * FROM students";
    private static final String INSERT_STUDENTS_QUERY = "INSERT INTO students (name, surname, course, idCity) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_STUDENTS_QUERY = "UPDATE students SET course=? WHERE id=?";
    private static final String DELETE_STUDENTS_QUERY = "DELETE FROM students WHERE id=?";
    private static final String GET_ALL_STUDENTS_QUERY_WITH_CITIESNAME = "SELECT students_db.students.name, students_db.cities.name" +
            " FROM students_db.students " +
            "left join students_db.cities " +
            "on students_db.cities.idcity = students_db.students.idcity";
    private static final String INSERT_CITIES_QUERY = "INSERT INTO cities (name) VALUES (?)";
    private static final String DELETE_CITIES_QUERY = "DELETE FROM cities WHERE idcity=?";
    private static final String GET_ALL_CITIES_QUERY = "SELECT * FROM cities";

    private static final String DISABLE_CHECK = "SET FOREIGN_KEY_CHECKS = 0;";

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                int course = rs.getInt("course");
                int idCity = rs.getInt("idcity");
                students.add(new Student(id, name, surname, course, idCity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<Student> addStudent(Student student) {
        List<Student> students = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENTS_QUERY);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getSurname());
            preparedStatement.setInt(3, student.getCourse());
            preparedStatement.setInt(4, student.getIdCity());
            preparedStatement.executeUpdate();
            students = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<Student> updateStudent(int id, int course) {
        List<Student> students = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENTS_QUERY);
            preparedStatement.setInt(1, course);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            students = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<Student> deleteStudent(int id) {
        List<Student> students = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENTS_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            students = getAllStudents();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return students;
    }

    public static List<StudentWithCity> getAllStudentsWithCities() {
        List<StudentWithCity> studentsWithCity = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS_QUERY_WITH_CITIESNAME);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String nameStudent = rs.getString(1);
                String nameCity = rs.getString(2);
                studentsWithCity.add(new StudentWithCity(nameStudent, nameCity));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentsWithCity;
    }

    public static List<City> addCity(City city) {
        List<City> cities = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CITIES_QUERY);
            preparedStatement.setString(1, city.getName());
            preparedStatement.executeUpdate();
            cities = getAllCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public static List<City> deleteCity(int id) {
        List<City> cities = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CITIES_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            cities = getAllCities();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }

    public static List<City> getAllCities() {
        List<City> cities = new ArrayList<>();
        Connection connection = DBUTILSAdditionalTask.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CITIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long idCity = rs.getLong("idcity");
                String name = rs.getString("name");
                cities.add(new City(idCity, name));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cities;
    }
}
