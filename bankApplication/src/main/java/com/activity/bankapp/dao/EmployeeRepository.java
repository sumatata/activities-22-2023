package com.activity.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.activity.bankapp.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
