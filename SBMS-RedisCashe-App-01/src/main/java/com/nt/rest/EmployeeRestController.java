package com.nt.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;

@RestController
public class EmployeeRestController {
		@Autowired
		private IEmployeeMgmtService service;
		
		@PostMapping("/employee")
		public ResponseEntity<String> saveEmpData(@RequestBody Employee emp){
			String msg = service.insertEmployee(emp);
			return new ResponseEntity<>(msg, HttpStatus.CREATED);
		}
		
		@GetMapping("/employee")
		public ResponseEntity<List<Employee>> fetchAllEmpData(){
			List<Employee> empList = service.getAllEmployee();
			return new ResponseEntity<>(empList, HttpStatus.OK);
		}
		
		@GetMapping("/employee/{id}")
		public ResponseEntity<Employee> fetchEmpById(@PathVariable Integer id){
			Employee empById = service.getEmployeeById(id);
			return new ResponseEntity<>(empById, HttpStatus.OK);
		}
		
		@PutMapping("/employee/{id}")
		public ResponseEntity<Employee> modifyEmpData(@PathVariable Integer id, @RequestBody Employee emp){
			Employee e = service.updateEmployee(id, emp);
			return new ResponseEntity<>(e, HttpStatus.OK);
		}
		
		@DeleteMapping("/employee/{id}")
		public ResponseEntity<Map<String, Boolean>> removeEmpById(@PathVariable Integer id){
			Map<String, Boolean> response = service.deleteEmployee(id);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
}
