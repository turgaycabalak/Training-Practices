package com.codeforgeyt.filtering.business;

import com.codeforgeyt.filtering.dataAccess.EmployeeCriteriaRepository;
import com.codeforgeyt.filtering.dataAccess.EmployeeRepository;
import com.codeforgeyt.filtering.entities.Employee;
import com.codeforgeyt.filtering.entities.EmployeePage;
import com.codeforgeyt.filtering.entities.EmployeeSearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;



    public Page<Employee> getEmployees(EmployeePage employeePage,
                                       EmployeeSearchCriteria employeeSearchCriteria){
        return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

}
