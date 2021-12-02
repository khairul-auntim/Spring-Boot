package com.crud.springboot.service;

import com.crud.springboot.model.Employees;
import com.crud.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.crud.springboot.exception.RequestNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employees> findAll() {
        return employeeRepository.findAll();
    }


    public Employees createEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    public ResponseEntity<Employees> findById(Long empId) throws RequestNotFoundException {
        Employees employee= employeeRepository.findById(empId).orElseThrow(()->new RequestNotFoundException("Employee not found"));
        return ResponseEntity.ok().body(employee);
    }

    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    public ResponseEntity<Employees> updatemployee(Long id, Employees employees) throws RequestNotFoundException{
        Employees emp=employeeRepository.findById(id).orElseThrow(()->new RequestNotFoundException("Employee Not Found"));
        emp.setFirstName(employees.getFirstName());
        emp.setLastName(employees.getLastName());
        emp.setEmail(employees.getEmail());
        final Employees updatedEmp= employeeRepository.save(emp);
        return ResponseEntity.ok().body(updatedEmp);
    }
}
