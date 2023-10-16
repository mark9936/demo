package com.demo.controller;

import com.demo.bean.school.StudentBean;
import com.demo.payload.ReqBody;
import com.demo.service.school.StudentService;
import com.demo.util.CommonResult;
import com.demo.util.constants.RouteConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Student", description = "Student management APIs")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Retrieve a Student by Id"
            , description = "Get a Student object by specifying its id. The response is Student object with id, GPA, name and personID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = CommonResult.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping(RouteConstants.STUDENT_GET_STUDENT + "/{studentId}")
    public ResponseEntity<?> getStudent(@PathVariable Integer studentId) {
        StudentBean res = studentService.findById(studentId);
        return ResponseEntity.ok(new CommonResult<>(res));
    }

    @GetMapping(RouteConstants.STUDENT_GET_ALL_STUDENT)
    public ResponseEntity<?> getStudents() {
        List<StudentBean> res = studentService.findAll();
        return ResponseEntity.ok(new CommonResult<>(res));
    }

    @PostMapping(RouteConstants.STUDENT_GET_SPECIFIC_STUDENT_GPA)
    public ResponseEntity<?> getStudentGpa(@RequestBody ReqBody req) {
        List<StudentBean> res = studentService.findBySpecificGPA(req.getStart(), req.getEnd());
        return ResponseEntity.ok(new CommonResult<>(res));
    }

}