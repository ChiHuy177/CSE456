package vn.eiu.edu.cse456;

import vn.eiu.edu.cse456.entity.Gender;
import vn.eiu.edu.cse456.entity.Major;
import vn.eiu.edu.cse456.entity.School;
import vn.eiu.edu.cse456.entity.Student;
import vn.eiu.edu.cse456.repository.implementation.MajorRepository;
import vn.eiu.edu.cse456.repository.implementation.SchoolRepository;
import vn.eiu.edu.cse456.repository.implementation.StudentRepository;
import vn.eiu.edu.cse456.service.implement.MajorService;
import vn.eiu.edu.cse456.service.implement.SchoolService;
import vn.eiu.edu.cse456.service.implement.StudentService;

import java.time.LocalDate;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        SchoolRepository schoolRepository = new SchoolRepository(School.class);
        SchoolService schoolService = new SchoolService(schoolRepository);

        StudentRepository studentRepository = new StudentRepository(Student.class);
        StudentService studentService = new StudentService(studentRepository);

        MajorRepository majorRepository = new MajorRepository(Major.class);
        MajorService majorService = new MajorService(majorRepository);

        School school = new School();
        school.setSchoolId("123");
        school.setSchoolName("EIU");
        school.setLocation("Location EIU");
        schoolService.save(school);

        Major major = new Major();
        major.setMajorId("CSE");
        major.setMajorName("Computer Science");
        major.setSchool(school);
        majorService.save(major);


        Student student = new Student("Chi Huy", Gender.MALE, LocalDate.parse("2003-07-17"), 4, 2021);
        student.setMajor(major);
        student.setSchool(school);
        studentService.save(student);
        school.addStudent(student);
        schoolService.update(school);

        
        List<School> schools = schoolRepository.findAll();
        for (School s : schools) {
            System.out.println(s.toString());
            for(Student st : s.getStudents()){
                System.out.println(st.toString());
            }
        }


    }
}
