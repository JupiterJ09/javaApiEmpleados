package com.schoolemployeeapi.repository;

import com.schoolemployeeapi.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    
}
