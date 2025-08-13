package vn.eiu.edu.cse456.lab_6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.lab_6.config.initdata.InitStudent;
import vn.eiu.edu.cse456.lab_6.entity.Student;

@Service
public class StudentService {

    private final InitStudent initStudent;

    @Autowired
    public StudentService(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    public List<Student> getStudents() {
        return initStudent.getStudents();
    }

    public void updateStudent(int id, String name, int yob, double gpa) {
        for (Student student : initStudent.getStudents()) {
            if (student.getId() == id) {
                student.setName(name);
                student.setYob(yob);
                student.setGpa(gpa);
                break;
            }
        }
    }

    public void addNewStudent(Student student) {
        initStudent.getStudents().add(student);
    }

    public void deleteStudent(int id) {
        for (Student student : initStudent.getStudents()) {
            if (student.getId() == id) {
                initStudent.getStudents().remove(student);
                break;
            }
        }
    }
}
