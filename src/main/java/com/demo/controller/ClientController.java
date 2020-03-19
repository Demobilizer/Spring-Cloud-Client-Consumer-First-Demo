/**
 * 
 */
package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Employee;

/**
 * @author Mehul
 **/

@RestController
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/rest-call-to-provider")
	public String callNow() {
		String url = "http://DEMO-PROVIDER-SERVICE/testNow";
		return restTemplate.getForObject(url, String.class);
	}
	
	@GetMapping("/get-all-employees")
	public String getAllEmployees() {
		String url = "http://DEMO-PROVIDER-SERVICE/viewEmployees";
		return restTemplate.getForObject(url, String.class);
	}
	
	@PostMapping("/add-employee")
	public String addEmployee(@RequestBody Employee employee) {
		String url = "http://DEMO-PROVIDER-SERVICE/save";
		restTemplate.postForObject(url, employee, Integer.class);
		return "employee added successfully";
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable int empId) {
		String url = "http://DEMO-PROVIDER-SERVICE/delete/{empId}";
		restTemplate.delete(url, empId);
		return "success";
	}
	
	@GetMapping("/findEmp/{empId}")
	public String findEmployeeById(@RequestBody int empId) {
		String url = "http://DEMO-PROVIDER-SERVICE/findEmp/{empId}";
		return restTemplate.getForObject(url, String.class, empId);
	}
	
	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		System.out.println("emp details---"+employee.toString());
		String url = "http://DEMO-PROVIDER-SERVICE/save";
		restTemplate.postForObject(url, employee, Integer.class);
		return "employee added successfully";
	}

}
