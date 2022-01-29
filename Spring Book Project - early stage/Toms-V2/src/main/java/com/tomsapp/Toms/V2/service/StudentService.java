package com.tomsapp.Toms.V2.service;

import com.tomsapp.Toms.V2.entity.Students;
import com.tomsapp.Toms.V2.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements StudentServiceInt {

    @Autowired
    StudentsRepository studentsRepository;


    @Override
    public List<Students> getStudents() {
        return studentsRepository.findAll();
    }

    @Override
    public void saveSrudent(Students tempStudents) {
        studentsRepository.save(tempStudents);
    }

    @Override
    public Students findbyId(int studentId) {
       return studentsRepository.getOne(studentId);
    }

    @Override
    public void deleteStudentbyId(int studentId) {
        studentsRepository.deleteById(studentId);
    }




}
