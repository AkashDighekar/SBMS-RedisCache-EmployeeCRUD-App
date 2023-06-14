package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {
		public String insertEmployee(Employee emp);
		public List<Employee> getAllEmployee();
		public Employee getEmployeeById(Integer id);
		public Employee updateEmployee(Integer id, Employee emp);
		public Map<String, Boolean> deleteEmployee(Integer id); 
}
