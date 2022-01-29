package com.luv2code.springdemo.controller;

import com.luv2code.springdemo.Student;
import com.luv2code.springdemo.rest.StudentErrorResponse;
import com.luv2code.springdemo.rest.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentRestController {


    List<Student> studentsList;

    @PostConstruct
    public void createStudents(){
        studentsList=new ArrayList<>();
        studentsList.add(new Student("Adam","Nowicki"));
        studentsList.add(new Student("Tomasz","Wolski"));
    }


    @GetMapping("/students/{StudentId}")
    public Student getStudents(@PathVariable int StudentId){

        if(StudentId>=studentsList.size() || StudentId<0){
            throw new StudentNotFoundException("Student o numerze nie znaleziony " + StudentId);
        }


        return studentsList.get(StudentId);

    }
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMassage(studentNotFoundException.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExceptionBad(Exception studentNotFoundException){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMassage(studentNotFoundException.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}
