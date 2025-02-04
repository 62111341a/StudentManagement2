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
    public List<StudentsCourses> searchStudentsCoursesList() { // メソッド名修正
        return repository.searchStudents_Courses(); // Repository 側で実装
    }

    // 学生登録
    @Transactional
    public void registerStudent(StudentDetail studentDetail) {
        if (studentDetail == null) {
            throw new IllegalArgumentException("studentDetail cannot be null");
        }

        // StudentDetail から Student オブジェクトを作成
        Student student = new Student();
        student.setFullName(studentDetail.getFullName());
        student.setFurigana(studentDetail.getFurigana());
        student.setNickName(studentDetail.getNickName());
        student.setEmail(studentDetail.getEmail());
        student.setAddress(studentDetail.getAddress());
        student.setAge(studentDetail.getAge());
        student.setGender(studentDetail.getGender());
        student.setEnrollmentDate(studentDetail.getEnrollmentDate());
        student.setRemark(studentDetail.getRemark());

        // 保存
        repository.save(student);
    }
}
