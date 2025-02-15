package raisetech.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import raisetech.studentmanagement.controller.converter.StudentConverter;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;
import raisetech.studentmanagement.moniter.StudentDetail;
import raisetech.studentmanagement.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService service;
    private final StudentConverter converter;

    @Autowired
    public StudentController(StudentService service, StudentConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/studentList")
    public String getStudentList(Model model) {
        List<Student> students = service.searchStudentList();
        List<StudentsCourses> studentsCourses = service.searchStudentsCoursesList();
        model.addAttribute("studentList", converter.convertStudentDetails(students, studentsCourses));
        return "studentList";
    }
    @GetMapping("/students_CourseList")
    @ResponseBody
    public List<StudentsCourses> getStudentsCourseList() {
        return service.searchStudentsCoursesList();
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        model.addAttribute("studentDetail", new StudentDetail());
        return "registerStudent";
    }

    @PostMapping("/registerStudent")
    public String registerStudent(@ModelAttribute StudentDetail studentDetail, BindingResult result) {
        if (result.hasErrors()) {
            return "registerStudent";
        }

        // 学生の情報をセット
        Student student = new Student();
        student.setFullName(studentDetail.getStudent().getFullName());
        student.setEmail(studentDetail.getStudent().getEmail());

        // 学生の登録処理
        service.registerStudent(studentDetail);  // registerStudent メソッドに統一

        // 登録後、学生リストページにリダイレクト
        return "redirect:/studentList";
    }
}
