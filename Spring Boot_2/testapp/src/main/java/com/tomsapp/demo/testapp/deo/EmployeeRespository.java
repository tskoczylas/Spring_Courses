package com.tomsapp.demo.testapp.deo;

import com.tomsapp.demo.testapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path="members")
public interface EmployeeRespository extends JpaRepository<Employee,Integer>
{
}
