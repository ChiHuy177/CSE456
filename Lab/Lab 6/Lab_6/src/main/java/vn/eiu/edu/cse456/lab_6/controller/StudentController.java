package vn.eiu.edu.cse456.lab_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.eiu.edu.cse456.lab_6.entity.Student;
import vn.eiu.edu.cse456.lab_6.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/students")
    public String getStudent(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "student-list";
    }

    @GetMapping("/students/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        for (Student foundStudent : studentService.getStudents()) {
            if (foundStudent.getId() == id) {
                model.addAttribute("student", foundStudent);
                break;
            }
        }
        return "student-form";
    }

    @PostMapping("/students/edit/result")
    public String editStudent(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("yob") int yob,
            @RequestParam("gpa") double gpa,
            RedirectAttributes redirectAttributes) {

        // Sử dụng StudentService để cập nhật thông tin
        studentService.updateStudent(id, name, yob, gpa);

        redirectAttributes.addFlashAttribute("id", id);
        redirectAttributes.addFlashAttribute("name", name);
        redirectAttributes.addFlashAttribute("yob", yob);
        redirectAttributes.addFlashAttribute("gpa", gpa);
        return "redirect:/students/edit/result";
    }

    @GetMapping("/students/edit/result")
    public String showResult(Model model) {
        return "result";
    }

    @PostMapping("/students/new")
    public String addNewStudent(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("yob") int yob,
                                @RequestParam("gpa") double gpa) {
        Student student = new Student(id, name, yob, gpa);
        studentService.addNewStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/new")
    public String showNewForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-new";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
