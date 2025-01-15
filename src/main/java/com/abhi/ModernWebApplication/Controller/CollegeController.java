package com.abhi.ModernWebApplication.Controller;

import com.abhi.ModernWebApplication.Models.Student;
import com.abhi.ModernWebApplication.Request.StudentRequest;
import com.abhi.ModernWebApplication.Service.CollegeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1") // this prefix will be required for all apis exposed from this controller
public class CollegeController {

    // logging using custom log to automatically add className and methodName
    // use annotation for finding the time taken in dao layer using AOP
    // @Operation -- api documentation

    @Autowired
    CollegeService collegeService;

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(collegeService.addStudent(studentRequest));
    }

}
