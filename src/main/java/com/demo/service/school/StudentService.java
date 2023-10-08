package com.demo.service.school;

import com.demo.bean.school.StudentBean;
import java.util.List;

/**
 * @Function: StudentService.java
 * @Description: Student Service
 * @author: kuo
 * @date: 2023/10/03
 * @MaintenancePersonnel: kuo
 */
public interface StudentService {

    StudentBean findById(Integer id);

    List<StudentBean> findAll();

    List<StudentBean> findBySpecificGPA(double start, double end);

}
