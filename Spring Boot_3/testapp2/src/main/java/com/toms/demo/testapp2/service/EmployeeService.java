package com.toms.demo.testapp2.service;

import com.toms.demo.testapp2.entity.Employee;
import com.toms.demo.testapp2.repository.EmployeeRep;
import org.apache.logging.log4j.util.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeServiceInt {

    @Autowired
    EmployeeRep employeeRep;

    public List<Employee> showEmployee(){
        return employeeRep.findAll().stream().sorted(Comparator.comparing(Employee::getFirstName)).collect(Collectors.toList());

    }

    public void  saveEmployee(Employee employee){
        employeeRep.saveAndFlush(employee);
    }

    @Override
    public Employee findById(int Id) {
        Optional<Employee> byId = employeeRep.findById(Id);
        Employee employee=null;
        if (byId.isPresent()) {
            employee=byId.get();
        }
        else throw new RuntimeException("Nie znaleziono uzytkownika");




        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
     employeeRep.deleteById(id);

    }


}
