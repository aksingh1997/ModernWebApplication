package com.abhi.ModernWebApplication.Dao;

import com.abhi.ModernWebApplication.Models.Student;
import com.abhi.ModernWebApplication.Models.StudentRepo;
import com.abhi.ModernWebApplication.Util.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeDao {
    @Autowired
    StudentRepo studentRepo;

    @LogExecutionTime
    public void addStudent(Student student) throws Exception {
        studentRepo.save(student);
    }
}
