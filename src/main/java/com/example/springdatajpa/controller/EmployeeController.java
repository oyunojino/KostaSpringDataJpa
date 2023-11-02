package com.example.springdatajpa.controller;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeDto;
import com.example.springdatajpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {
  private final EmployeeService employeeService;
  @PostMapping
  public Employee addEmployee(@RequestBody Employee employee) {
    return employeeService.addEmployee(employee);
  }

  @GetMapping
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{empId}")
  public Employee getEmployee(@PathVariable String empId) {
    return employeeService.getEmployee(empId).get();
  }

  @PutMapping("/{empId}")
  public String updateEmployee(@PathVariable String empId,
                               @RequestBody EmployeeDto employeeDto) {
    return employeeService.updateEmployee(employeeDto);
  }

  @DeleteMapping("/{empId}")
  public String deleteEmployee(@PathVariable String empId) {
    return employeeService.deleteEmployee(empId);
  }
}
