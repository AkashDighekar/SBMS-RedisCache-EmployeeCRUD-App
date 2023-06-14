package com.nt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repository.EmployeeRepository;
@Service
public class EmployeeImplService implements IEmployeeMgmtService {

	Logger logger = LoggerFactory.getLogger(EmployeeImplService.class);
	private EmployeeRepository repo;
	
	public EmployeeImplService(EmployeeRepository repo) {
			this.repo = repo; 
	}
	
	@Override
	public String insertEmployee(Employee emp) {
		repo.save(emp);
		return "Employee Added....";
	}

	@Override
	@Cacheable(value = "Employee")
	public List<Employee> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	@Cacheable(value = "Employee", key = "#id")
	public Employee getEmployeeById(Integer id) {
		try {
			Employee e = repo.findById(id).orElseThrow(()-> 
			new EmployeeNotFoundException("Employee Not Exist for this Id"));
			return e;
		}catch(Exception ex) {
			logger.error("Employee is not Available",id , ex);
			throw ex;
		}
		
	}

	@Override
	@CachePut(value = "Employee", key = "#id")
	public Employee updateEmployee(Integer id, Employee emp) {
		Employee e = repo.findById(id).orElseThrow(()->
									new EmployeeNotFoundException("Employee Not Exist for this Id"));
		e.setFname(emp.getFname());
		e.setLname(emp.getLname());
		e.setAge(emp.getAge());
		e.setEmail(emp.getEmail());
		e.setPhone(emp.getPhone());
		e.setAddress(emp.getAddress());
		Employee updateEmp = repo.save(e);
		return updateEmp;
	}

	@Override
	@CacheEvict(value = "Employee", key = "#id")
	public Map<String, Boolean> deleteEmployee(Integer id) {
		Employee e = repo.findById(id).orElseThrow(()-> 
									new EmployeeNotFoundException("Employee Not Exist for this Id"));
		repo.delete(e);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("Employee Deleted....", Boolean.TRUE);
		return map;
	}

}
