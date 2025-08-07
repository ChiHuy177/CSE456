package vn.eiu.edu.cse456.lab_6.config.initdata;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import vn.eiu.edu.cse456.lab_6.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitStudent {
    private List<Student> students;

    @PostConstruct
    public void initStudent() {
        students = new ArrayList<>();
        students.add(new Student(1, "Nhất", 2000, 95));
        students.add(new Student(2, "Huy", 2001, 90));
        students.add(new Student(3, "Minh", 2002, 92));
    }

    public List<Student> getStudents() {
        return students;
    }
}
