package vn.eiu.edu.cse456.fecse4562131200104demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_name", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;
    @Column(name = "student_yob", columnDefinition = "INT", nullable = false)
    private int yob;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    public Student(String name, int yob) {
        this.name = name;
        this.yob = yob;
    }
}
