package vn.eiu.edu.cse456.lab_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.eiu.edu.cse456.lab_6.config.initdata.InitStudent;

@Controller
public class StudentController {
    private final InitStudent initStudent;

    @Autowired
    public StudentController(InitStudent initStudent) {
        this.initStudent = initStudent;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/getStudent")
    public String getStudent() {
        return "student-list";
    }
}
