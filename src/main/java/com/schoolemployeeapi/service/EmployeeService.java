package com.schoolemployeeapi.service;

import com.schoolemployeeapi.entity.Employee;
import com.schoolemployeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.schoolemployeeapi.exception.ResourceNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id){

        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee empleado){
        return employeeRepository.save(empleado);
        //System.out.println("Empleado registrado con exito");
    }


    public void deleteEmployee(Long id){

        if(employeeRepository.existsById(id)){

            employeeRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("No se encontró al empleado con ID: " + id);
        }
        

    }
    
}
