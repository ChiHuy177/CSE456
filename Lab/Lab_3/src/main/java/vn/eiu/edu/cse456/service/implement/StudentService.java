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

    public void deleteById(String id){
        try {
            studentRepository.deleteById(id);
            System.out.println("Delete student with id: " + id + " success!");
        } catch (Exception e) {
            System.out.println("Delete student with id: " + id + " failed!");
            throw new RuntimeException(e);
        }
    }
}
