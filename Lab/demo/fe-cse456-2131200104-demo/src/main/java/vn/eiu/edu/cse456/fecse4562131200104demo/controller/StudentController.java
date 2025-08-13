package vn.eiu.edu.cse456.fecse4562131200104demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.eiu.edu.cse456.fecse4562131200104demo.model.Student;
import vn.eiu.edu.cse456.fecse4562131200104demo.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public String student(Model model) {

        List<Student> students = studentService.findAll();
        model.addAttribute("studentList", students);

        return "student-list";
    }
}
