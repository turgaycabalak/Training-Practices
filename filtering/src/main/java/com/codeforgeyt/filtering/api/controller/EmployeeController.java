package com.codeforgeyt.filtering.api.controller;

import com.codeforgeyt.filtering.business.EmployeeService;
import com.codeforgeyt.filtering.entities.Employee;
import com.codeforgeyt.filtering.entities.EmployeePage;
import com.codeforgeyt.filtering.entities.EmployeeSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<?> getEmployees(EmployeePage employeePage,
                                          EmployeeSearchCriteria employeeSearchCriteria){
        return new ResponseEntity<>(employeeService.getEmployees(employeePage, employeeSearchCriteria), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

}
