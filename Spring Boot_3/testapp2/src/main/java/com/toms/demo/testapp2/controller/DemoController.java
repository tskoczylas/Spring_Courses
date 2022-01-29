package com.toms.demo.testapp2.controller;

import com.toms.demo.testapp2.entity.Employee;
import com.toms.demo.testapp2.service.EmployeeServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class DemoController {


@Autowired
 EmployeeServiceInt employeeServiceInt;


    @GetMapping("/employee")
    public String emplo(Model model){

        model.addAttribute("employeeList",employeeServiceInt.showEmployee());

        System.out.println(employeeServiceInt.showEmployee());

        return "employee-list";


    }

    @GetMapping("/add")
    public String addEm(Model model)
    {
        Employee employee = new Employee();

        model.addAttribute("employee",employee);

        return "add-employee";
    }

    @GetMapping("/update")
public String updateEmpl(@RequestParam("employeeId") int id,Model model)
    {
        Employee employee=employeeServiceInt.findById(id);

        model.addAttribute("employee",employee);

        return "add-employee";

    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {

    employeeServiceInt.saveEmployee(employee);



        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("employeeId") int emId )

    {
        employeeServiceInt.deleteEmployee(emId);

        return "redirect:/employee";
    }

}
