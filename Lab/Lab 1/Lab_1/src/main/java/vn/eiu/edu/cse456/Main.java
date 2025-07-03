package vn.eiu.edu.cse456;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import vn.eiu.edu.cse456.models.Course;
import vn.eiu.edu.cse456.models.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Student student = new Student("123456", "John", "Doe1", 1999, 3.8);
        Student student2 = new Student("123456", "John", "Doe2", 1999, 3.8);
        Student student3 = new Student("123456", "John", "Doe3", 1999, 3.8);

        System.out.println(student.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        Course course = new Course("CSE 456", "Advanced Java Programming", 4, 60);
        Course course2 = new Course();
        course2.setName("Introduce to database");
        course2.setIdCourse("CSE 301");
        course2.setCredit(3);
        course2.setHours(30);
        System.out.println(course.toString());
        System.out.println(course2.toString());

        String jsonMapper = mapper.writeValueAsString(student);
        System.out.println(jsonMapper);


        //Assignment 2
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/cse456_q3_2025";
            connection = DriverManager.getConnection(url, "root", "123456789");
            System.out.println("Connected to database");
            PreparedStatement pstmt = connection.prepareStatement("select * from Student");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("id") + " "
                        + rs.getString("first_name") + " "
                        + rs.getString("last_name") + " "
                        + rs.getInt("year_of_birth") + " "
                        + rs.getDouble("gpa"));
            }

            PreparedStatement pstmt2 = connection.prepareStatement("select * from Course");

            ResultSet rs2 = pstmt2.executeQuery();
            while (rs2.next()) {
                System.out.println(rs2.getString("id_course") + " "
                        + rs2.getString("name") + " "
                        + rs2.getString("credit") + " "
                        + rs2.getInt("hours") + " ");
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}