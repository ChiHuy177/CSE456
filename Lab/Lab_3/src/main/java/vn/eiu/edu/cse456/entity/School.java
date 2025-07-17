package vn.eiu.edu.cse456.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "tbl_school")
public class School {
    @Id
    @Column(name = "schoolId", columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "schoolName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String schoolName;

    @Column(name = "location", columnDefinition = "VARCHAR(100)", nullable = true)
    private String location;

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Major> majors = new ArrayList<>();

    @OneToMany(mappedBy = "school", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();


}
