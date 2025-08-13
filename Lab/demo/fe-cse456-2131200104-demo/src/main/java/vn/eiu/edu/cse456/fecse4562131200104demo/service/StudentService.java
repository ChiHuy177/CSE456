package vn.eiu.edu.cse456.fecse4562131200104demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Student;
import vn.eiu.edu.cse456.fecse4562131200104demo.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;

    public void save(Student student) {
        studentRepo.save(student);
    }

    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
