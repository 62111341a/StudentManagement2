package raisetech.studentmanagement.repository;

import org.apache.ibatis.annotations.*;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;

import java.util.List;

@Mapper
public interface StudentRepository {
    @Select("SELECT * FROM students")
    List<Student> search();
    @Select("SELECT * FROM students_courses")
    List<StudentsCourses> searchStudents_Courses();

}
