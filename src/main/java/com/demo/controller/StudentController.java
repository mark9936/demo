package com.demo.controller;

import com.demo.bean.school.StudentBean;
import com.demo.payload.ReqBody;
import com.demo.service.school.StudentService;
import com.demo.util.CommonResult;
import com.demo.util.constants.RouteConstants;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(RouteConstants.STUDENT_GET_STUDENT + "/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Integer studentId) {
        System.out.print("*************getStudent");
        StudentBean res = studentService.findById(studentId);
        return ResponseEntity.ok(new CommonResult<>(res));
    }

    @GetMapping(RouteConstants.STUDENT_GET_ALL_STUDENT)
    public ResponseEntity<?> getStudents() {
        System.out.print("*************getStudents");
        List<StudentBean> res = studentService.findAll();
        return ResponseEntity.ok(new CommonResult<>(res));
    }

    @PostMapping(RouteConstants.STUDENT_GET_SPECIFIC_STUDENT_GPA)
    public ResponseEntity<?> getStudentGpa(@RequestBody ReqBody req) {
        System.out.print("*************getstudentgpa");
        List<StudentBean> res = studentService.findBySpecificGPA(req.getStart(), req.getEnd());
        return ResponseEntity.ok(new CommonResult<>(res));
    }

}