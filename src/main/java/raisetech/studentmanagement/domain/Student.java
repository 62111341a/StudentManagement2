package raisetech.studentmanagement.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
   private String studentId;
   private String FullName;
   private String Furigana;
   private String NickName;
   private String Email;
   private String Address;
   private String Age;
   private String Gender;
   private String EnrollmentDate;
   private String remark;
   private boolean isDeleted;
}
