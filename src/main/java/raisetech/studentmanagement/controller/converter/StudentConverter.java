package raisetech.studentmanagement.controller.converter;

import org.springframework.stereotype.Component;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;
import raisetech.studentmanagement.moniter.StudentDetail;  // 修正したインポート

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {
    public List<StudentDetail> convertStudentDetails(List<Student> students, List<StudentsCourses> studentsCourses) {
        if (students == null || studentsCourses == null) {
            return new ArrayList<>(); // null回避
        }

        List<StudentDetail> studentDetails = new ArrayList<>();
        students.forEach(student -> {
            StudentDetail studentDetail = new StudentDetail();
            studentDetail.setStudent(student);

            List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
                    .filter(studentsCourse -> student.getStudentId().equals(studentsCourse.getStudentId()))  // 修正
                    .collect(Collectors.toList());

            studentDetail.setStudentsCourses(convertStudentCourses);
            studentDetails.add(studentDetail);
        });

        return studentDetails;
    }
}
