package raisetech.studentmanagement.moniter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;
@Getter
@Setter
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class StudentDetail {

    private Student student; // 追加

    private List<StudentsCourses> studentsCourses; // 追加


}