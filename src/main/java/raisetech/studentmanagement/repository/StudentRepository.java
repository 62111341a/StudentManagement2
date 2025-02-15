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

    @Insert("INSERT INTO students VALUES(#{id},#{fullName}, #{furigana}, #{nickName}, #{email}, #{address}, #{age}, #{gender} ,#{enrollmentDate}, #{remark},false")
    void registerStudent(Student student);

}
