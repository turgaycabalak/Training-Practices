package com.codeforgeyt.filtering.dataAccess;

import com.codeforgeyt.filtering.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {





}
