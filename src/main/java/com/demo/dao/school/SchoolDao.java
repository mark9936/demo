package com.demo.dao.school;

import com.demo.model.school.Student;
import java.util.List;

public interface SchoolDao {

    List<Student> findBySpecificGPA(double start, double end);
}
