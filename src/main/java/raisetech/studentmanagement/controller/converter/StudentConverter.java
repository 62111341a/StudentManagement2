package raisetech.studentmanagement.controller.converter;

import org.springframework.stereotype.Component;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;
import raisetech.studentmanagement.moniter.StudentDetail;

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

            // Student の情報をセット
            studentDetail.setStudent(student);

            // 学生コース情報をフィルタリングしてセット
            List<StudentsCourses> convertStudentCourses = studentsCourses.stream()
                    .filter(studentsCourse -> student.getId().equals(studentsCourse.getStudentId()))
                    .collect(Collectors.toList());

            studentDetail.setStudentsCourses(convertStudentCourses);

            // `Student` オブジェクト全体をセット（新しく追加したフィールドに）
            studentDetail.setStudent(student);

            studentDetails.add(studentDetail);
        });

        return studentDetails;
    }
}
