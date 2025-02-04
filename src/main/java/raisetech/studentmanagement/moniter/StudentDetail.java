package raisetech.studentmanagement.moniter;


import lombok.Getter;
import lombok.Setter;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;

import java.util.List;

@Getter
@Setter
public class StudentDetail {
    private Student student; // Studentフィールド
    private List<StudentsCourses> studentsCourses; // 学生のコース情報（setter自動生成）



}
