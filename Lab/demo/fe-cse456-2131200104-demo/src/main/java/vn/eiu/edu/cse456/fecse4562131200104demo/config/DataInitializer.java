package vn.eiu.edu.cse456.fecse4562131200104demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Major;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Student;
import vn.eiu.edu.cse456.fecse4562131200104demo.service.MajorService;
import vn.eiu.edu.cse456.fecse4562131200104demo.service.StudentService;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    MajorService majorService;
    StudentService studentService;

    @Override
    public void run(String... args) throws Exception {
        Student std1 = new Student("ChiHuy", 2003);
        Student std2 = new Student("ChiMinh", 2004);
        Student std3 = new Student("ABC", 2005);

        Major mj1 = new Major("CSE", "Computer Science and Engineering");
        Major mj2 = new Major("EEE", "Electrical and Electronics Engineering");

        mj1.addStudent(std1);
        mj2.addStudent(std2);
        mj2.addStudent(std3);

        majorService.save(mj1);
        majorService.save(mj2);

    }
}
