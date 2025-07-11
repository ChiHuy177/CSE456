package vn.eiu.edu.cse456.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Students")
@Data
public class Student {
    @Id
    @Column(name = "Id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "Name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;

    @Column(name = "YOB", columnDefinition = "INT", nullable = false)
    private int yOB;

    @Column(name = "GPA", columnDefinition = "DOUBLE", nullable = false)
    private double gpa;

}
