package com.toms.demo.testapp2.repository;

import com.toms.demo.testapp2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRep extends JpaRepository<Employee,Integer> {


}
