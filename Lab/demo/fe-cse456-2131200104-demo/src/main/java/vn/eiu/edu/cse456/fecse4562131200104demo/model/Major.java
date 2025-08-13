package vn.eiu.edu.cse456.fecse4562131200104demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id")
    private Long id;

    @Column(name = "major_name", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "major_description", columnDefinition = "TEXT")
    private String description;

    //mappedBy = "tên thuộc tính obj của Major đã đặt bên student
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setMajor(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setMajor(null);
    }

    public Major(String description, String name) {
        this.description = description;
        this.name = name;
    }
}
