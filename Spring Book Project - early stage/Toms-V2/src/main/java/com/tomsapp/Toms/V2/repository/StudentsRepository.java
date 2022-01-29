package com.tomsapp.Toms.V2.repository;

import com.tomsapp.Toms.V2.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Integer> {
}
