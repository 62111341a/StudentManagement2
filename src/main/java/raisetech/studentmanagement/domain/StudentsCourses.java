package raisetech.studentmanagement.domain;

import java.time.LocalDateTime;

public class StudentsCourses {
    private Long studentId;  // フィールド名を修正
    private String courseName;
    private String startDate;
    private String endDate;
    private LocalDateTime courseStartAt;
    private LocalDateTime courseEndAt;

    // Getter for studentId
    public Long getStudentId() {  // メソッド名を修正
        return studentId;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Getter for startDate
    public String getStartDate() {
        return startDate;
    }

    // Getter for endDate
    public String getEndDate() {
        return endDate;
    }

    // Getter for courseStartAt
    public LocalDateTime getCourseStartAt() {
        return courseStartAt;
    }

    // Getter for courseEndAt
    public LocalDateTime getCourseEndAt() {
        return courseEndAt;
    }
}
