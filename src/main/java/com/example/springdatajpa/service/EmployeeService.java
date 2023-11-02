package com.example.springdatajpa.service;

import com.example.springdatajpa.domain.Employee;
import com.example.springdatajpa.domain.EmployeeDto;
import com.example.springdatajpa.reposistory.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
//@Transactional -> 전체 적용됨
public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  @Autowired
  public EmployeeService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Transactional(readOnly = true)
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();

  }

  @Transactional
  public Employee addEmployee(Employee employee) {
    Employee save = employeeRepository.save(employee);
    return save;
  }


  @Transactional(readOnly = true)
  public Optional<Employee> getEmployee(String empId) { // optional test 추가
    Optional<Employee> byId = employeeRepository.findById(empId);
    return byId;
  }

  @Transactional
  public String updateEmployee(EmployeeDto employeeDto) {
//  update는 DTO를 만드는 것이 좋음
    Optional<Employee> findEmployee = employeeRepository.findById(employeeDto.getEmpId());
    Employee employee = findEmployee.get();
    employee.setDeptId(employeeDto.getDeptId());
    employee.setSalary(employeeDto.getSalary());
    return "수정 완료";
  }

  @Transactional
  public String deleteEmployee(String empId) {
    employeeRepository.deleteById(empId);
    return "삭제 완료";
  }
}
