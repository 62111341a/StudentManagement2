package raisetech.studentmanagement.domain;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
public class Student {

   private Long id;
   private String fullName;
   private String furigana;
   private String nickName;
   private String email;
   private String address;
   private int age;
   private String gender;
   private LocalDate enrollmentDate;
   private String remark;
}
