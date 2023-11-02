package com.example.springdatajpa.reposistory;

import com.example.springdatajpa.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
