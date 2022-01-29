package com.tomsapp.Toms.V2.service;

import com.tomsapp.Toms.V2.entity.Students;

import java.util.List;

public interface StudentServiceInt {


    public List<Students> getStudents();
    public void saveSrudent(Students tempStudents);
    public Students findbyId(int studentId);


    void deleteStudentbyId(int studentId);
}
