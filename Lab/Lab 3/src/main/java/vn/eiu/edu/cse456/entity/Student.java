package vn.eiu.edu.cse456.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId", columnDefinition = "BIGINT")
    private int studentId;

    @Column(name = "fullName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String fullName;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "dob",columnDefinition = "Date", nullable = false)
    private LocalDate dob;

    @Column(name = "gpa", columnDefinition = "DOUBLE", nullable = false)
    private double gpa;

    @Column(name = "enrollmentYear", columnDefinition = "INT", nullable = false)
    private int enrollmentYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolId", nullable = false)
    private School school;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "majorId")
    private Major major;

    public Student(String fullName, Gender gender, LocalDate dob, double gpa, int enrollmentYear) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.gpa = gpa;
        this.enrollmentYear = enrollmentYear;
    }

    @Override
    public String toString() {
        return this.fullName + " " + this.studentId;
    }
}
