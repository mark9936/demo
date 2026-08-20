package com.demo.service.school;

import com.demo.model.school.Student;
import java.util.List;

/** Student 的商業邏輯介面，定義完整 CRUD 與 DAO 查詢範例。 */
public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    Student create(Student student);

    Student update(Integer id, Student student);

    void delete(Integer id);

    List<Student> findByGpaBetween(double minGpa, double maxGpa);

    List<Student> search(String studentName, Double minGpa, Double maxGpa);
}
