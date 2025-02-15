package raisetech.studentmanagement.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentsCourses {
    private String id;
    private Long studentId;  // フィールド名を修正
    private String courseName;
    private LocalDateTime courseStartAt;
    private LocalDateTime courseEndAt;

}