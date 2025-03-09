package raisetech.StudentManagement.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCoursesList();

  @Select("SELECT * FROM students_courses WHERE id = #{id}")
  List<StudentsCourses> searchStudentsCourses(String id);

  @Insert("INSERT INTO students(name, kanaName, nickname, email, area, age, sex, remark, is_deleted) "
      + "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{sex}, #{remark}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(student_id, course_name, course_start_at, course_end_at) "
          + "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);


  @Update("UPDATE students SET name = #{name}, kanaName = #{kanaName}, nickname = #{nickname}, email = #{email}, area = #{area}, age = #{age}, sex = #{sex}, remark = #{remark}, is_deleted = #{Deleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course_name = #{courseName}, course_start_at = #{courseStartAt}, course_end_at = #{courseEndAt} WHERE id = #{id}")
  void updateStudentsCourses(StudentsCourses studentsCourses);

}

