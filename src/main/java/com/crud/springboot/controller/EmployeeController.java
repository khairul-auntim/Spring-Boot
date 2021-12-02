package com.crud.springboot.controller;

import com.crud.springboot.model.Employees;
import com.crud.springboot.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crud.springboot.exception.RequestNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    //Get all employees API

    @GetMapping("/employees")
    public List<Employees> getAllEmployees(){
        return  employeeService.findAll();
    }

    // Create employees API
    @PostMapping("/create-emp")
    public Employees createEmployee(@RequestBody Employees employee){
        return employeeService.createEmployee(employee);
    }

    //Get employees by ID API

    @GetMapping("/emp/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable(value = "id") Long empId) throws RequestNotFoundException{
        return employeeService.findById(empId);
    }

    //Update employees API
    @PutMapping("/update-emp/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable("id") Long id, @RequestBody Employees employees) throws RequestNotFoundException {
        return employeeService.updatemployee(id, employees);
    }


    //Delete employees API

    @DeleteMapping("/delete-emp/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }




}
