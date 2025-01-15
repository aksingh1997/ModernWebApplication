package com.abhi.ModernWebApplication.Service;

import com.abhi.ModernWebApplication.Constants.CollegeCodes;
import com.abhi.ModernWebApplication.Dao.CollegeDao;
import com.abhi.ModernWebApplication.Exception.CollegeException;
import com.abhi.ModernWebApplication.Models.Student;
import com.abhi.ModernWebApplication.Request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {

    @Autowired
    CollegeDao collegeDao;

    public String addStudent(StudentRequest studentRequest) {
        // we can also use mapstruct for mapping one object to another, mapstruct with lombok are generally not compatible
        // Use this link for lombok + mapstruct - https://www.baeldung.com/java-mapstruct-lombok
        Student student = Student.builder().id(studentRequest.getId())
                .age(studentRequest.getAge())
                .name(studentRequest.getName())
                .subjectStream(studentRequest.getSubjectStream())
                .build();
        try {
            // int x = 6 / 0; // uncomment this to get forceful exception
            collegeDao.addStudent(student);
        } catch( Exception ex ) {
            throw new CollegeException(CollegeCodes.CollegeServiceException.getCode(),
                    CollegeCodes.CollegeServiceException.getMessage(), ex);
        }
        return "Data saved!!";
    }
}
