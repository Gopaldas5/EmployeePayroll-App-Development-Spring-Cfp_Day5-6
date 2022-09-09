package com.bridgelabz.springemployeepayrollappdevelopment_day5.services;

import com.bridgelabz.springemployeepayrollappdevelopment_day5.dto.EmployeePayrollDTO;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.exception.CustomException;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.model.EmployeePayrollData;
import com.bridgelabz.springemployeepayrollappdevelopment_day5.repository.EmployeePayrollRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepo employeePayrollRepo;

    //Method to add new employee details to database.
    public EmployeePayrollData addEmployee(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollDataObj = new EmployeePayrollData(employeePayrollDTO);
        return employeePayrollRepo.save(employeePayrollDataObj);
    }

    public Optional<EmployeePayrollData> findEmployeeID(int id) {
        if (employeePayrollRepo.findById(id).isPresent()) {
            return employeePayrollRepo.findById(id);
        } else {
            throw new CustomException("Employee id not found");
        }
    }

    public List<EmployeePayrollData> findAllEmployees() {
        if (!employeePayrollRepo.findAll().isEmpty()) {
            return employeePayrollRepo.findAll();
        } else {
            throw new CustomException("Employee data is empty");
        }
    }


    }

}
