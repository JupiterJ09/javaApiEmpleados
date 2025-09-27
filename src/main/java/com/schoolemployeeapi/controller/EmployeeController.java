package com.schoolemployeeapi.controller;

import com.schoolemployeeapi.entity.*;
import com.schoolemployeeapi.exception.ResourceNotFoundException;
import com.schoolemployeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeById(@PathVariable Long id) {

        Employee employee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new com.schoolemployeeapi.exception.ResourceNotFoundException(
                        "No se encontró al empleado con ID: " + id));

        return ResponseEntity.ok(employee);

    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {

        Employee existingEmployee = employeeService.getEmployeeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el empleado con ID: " + id));

        existingEmployee.setFirstName(employeeDetails.getFirstName());
        existingEmployee.setLastName(employeeDetails.getLastName());
        existingEmployee.setCorreo(employeeDetails.getCorreo());
        existingEmployee.setDepartament(employeeDetails.getDepartament());
        existingEmployee.setOcupacion(employeeDetails.getOcupacion());


        Employee updateEmployee = employeeService.saveEmployee(existingEmployee);
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){

         employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

}
