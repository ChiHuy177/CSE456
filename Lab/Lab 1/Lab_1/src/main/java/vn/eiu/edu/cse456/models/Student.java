package vn.eiu.edu.cse456.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private double gpa;

    //constructor
    public Student(String id, String firstName, String lastName, int yearOfBirth, double gpa) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.gpa = gpa;
    }

    //getter and setter

}
