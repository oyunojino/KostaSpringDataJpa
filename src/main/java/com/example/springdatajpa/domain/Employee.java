package com.example.springdatajpa.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
  @Id
  @Column(name = "emp_id")
  private String empId;
  @Column(name = "emp_name")
  private String empName;
  @Column(name = "dept_id")
  private int deptId;
  @Column(name = "join_date")
  private String joinDate;
  private long salary;
}
