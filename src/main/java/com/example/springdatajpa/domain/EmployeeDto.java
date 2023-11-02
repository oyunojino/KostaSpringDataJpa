package com.example.springdatajpa.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
  private String empId;
  private int deptId;
  private long salary;
}
