package com.toms.demo.testapp2.service;

import com.toms.demo.testapp2.entity.Employee;
import com.toms.demo.testapp2.repository.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmployeeServiceInt {

    List<Employee> showEmployee();
    void  saveEmployee(Employee employee);
    Employee findById(int Id);
    void deleteEmployee(int id);



}
