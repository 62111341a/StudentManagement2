package raisetech.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.studentmanagement.domain.Student;
import raisetech.studentmanagement.domain.StudentsCourses;
import raisetech.studentmanagement.moniter.StudentDetail; // monitor のスペル確認
import raisetech.studentmanagement.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {

        this.repository = repository;
    }

    // 学生リスト検索
    public List<Student> searchStudentList() {

        return repository.search();
    }

    // 学生とコースの関係を検索
    public List<StudentsCourses> searchStudentsCoursesList() {

        return repository.searchStudents_Courses();
    }
    @Transactional
    public void registerStudent(StudentDetail studentDetail){
       repository.registerStudent( studentDetail.getStudent());
    }
    // 学生登録


}
