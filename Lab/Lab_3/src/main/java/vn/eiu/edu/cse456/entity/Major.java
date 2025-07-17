package vn.eiu.edu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbl_major")
public class Major {
    @Id
    @Column(name = "majorId", columnDefinition = "CHAR(4)")
    private String majorId;
    @Column(name = "majorName", columnDefinition = "VARCHAR(100)", nullable = false)
    private String majorName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schoolId", nullable = false)
    private School school;

    @OneToMany(mappedBy = "major", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private java.util.List<Student> students = new ArrayList<>();
}
