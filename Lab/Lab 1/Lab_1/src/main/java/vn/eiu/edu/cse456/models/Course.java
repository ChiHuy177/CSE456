package vn.eiu.edu.cse456.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor //pt khởi tạo không tham số
@AllArgsConstructor //pt khởi tạo full tham số
@ToString
public class Course {
    private String idCourse;
    private String name;
    private int credit;
    private double hours;
}
