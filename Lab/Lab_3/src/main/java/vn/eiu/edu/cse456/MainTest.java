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
        StringBuilder sb = new StringBuilder();
        SchoolRepository schoolRepository = new SchoolRepository(School.class);
        SchoolService schoolService = new SchoolService(schoolRepository);

        StudentRepository studentRepository = new StudentRepository(Student.class);
        StudentService studentService = new StudentService(studentRepository);

        MajorRepository majorRepository = new MajorRepository(Major.class);
        MajorService majorService = new MajorService(majorRepository);

//        schoolService.deleteById("123");

//        majorService.deleteById("CSW");

//        studentService.deleteById("10");

        School school = new School();
        school.setSchoolId("123");
        school.setSchoolName("EIU");
        school.setLocation("Location EIU");
        schoolService.save(school);
//
        Major major = new Major();
        major.setMajorId("CSE");
        major.setMajorName("Computer Science");
        major.setSchool(school);
        majorService.save(major);
//
//
        Student student = new Student("Chi Huy", Gender.MALE, LocalDate.parse("2003-07-17"), 4, 2021);
        Major cseMajor = new Major("CSE1","Software Engineering");
        cseMajor.setSchool(school);
        majorService.save(cseMajor);

        Major cswMajor = new Major("CSW","Networking and Data Transportation");
        cswMajor.setSchool(school);
        majorService.save(cswMajor);


        Student std1 = new Student("Nhất trương", Gender.MALE, LocalDate.parse("2000-02-05"),8.1, 2021);
        Student std2 = new Student("Nhị Nguyễn", Gender.FEMALE, LocalDate.parse("2001-05-15"),8.4, 2021);
        Student std3 = new Student("Tam Lương", Gender.FEMALE, LocalDate.parse("2000-12-25"),8.1, 2021);
        Student std4 = new Student("Tứ Lý", Gender.MALE, LocalDate.parse("2001-03-13"),8.1, 2021);


        std1.setSchool(school);
        std2.setSchool(school);
        std3.setSchool(school);
        std4.setSchool(school);

        std1.setMajor(cseMajor);
        std2.setMajor(cseMajor);

        std3.setMajor(cswMajor);
        std4.setMajor(cswMajor);

        studentService.save(std1);
        studentService.save(std2);
        studentService.save(std3);
        studentService.save(std4);

        std1.setMajor(null);
        studentService.update(std1);


//        school.addStudent(std1);
//        school.addStudent(std2);
//        school.addStudent(std3);
//        school.addStudent(std4);
//
//        cswMajor.addStudent(std1);
//        cswMajor.addStudent(std2);
//        cseMajor.addStudent(std3);
//        cseMajor.addStudent(std4);

//
//        cswMajor.removeStudent(std1);
//
        cswMajor.setMajorName("Network and Data Transportation");
        majorService.update(cswMajor);









//        student.setMajor(major);
//        student.setSchool(school);
//        studentService.save(student);
//        school.addStudent(student);
//        schoolService.update(school);
//
//
//        List<School> schools = schoolRepository.findAllWithStudents();
//        for (School s : schools) {
//            System.out.println(s.toString());
//            for(Student st : s.getStudents()){
//                System.out.println(st.toString());
//            }
//        }


    }
}
