package vn.eiu.edu.cse456.service.implement;

import vn.eiu.edu.cse456.entity.Student;
import vn.eiu.edu.cse456.repository.implementation.StudentRepository;
import vn.eiu.edu.cse456.service.interfaces.IStudentService;

public class StudentService implements IStudentService {

    StudentRepository  studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public void delete(Student student){
        studentRepository.delete(student);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }
}
