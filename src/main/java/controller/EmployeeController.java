package controller;

import java.net.InetAddress;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import service.EmployeeService;

@Controller
@Slf4j
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/fetchEmployee")
	public Employee fetchEmployee(String id) {

		InetAddress IP = InetAddress.getLocalHost();

		log.info("Fetching Employee.");
		log.info("IP address: " + IP.getHostAddress() + "  Date: " + new Date());
		return service.fetchEmployee(id);

	}

	@PostMapping("/deleteEmployee")
	public boolean deleteEmployee(String id) {

		InetAddress IP = InetAddress.getLocalHost();
		log.info("Deleting Employee.");

		log.info("IP address: " + IP.getHostAddress() + "  Date: " + new Date());
		return service.deleteEmployee(id);

	}

	@PostMapping("/insertEmployee")
	public boolean insertEmployee(Employee employee) {

		InetAddress IP = InetAddress.getLocalHost();
		log.info("Inserting new Employee.");
		log.info("IP address: " + IP.getHostAddress() + " Date: " + new Date());
		return service.saveEmployee(employee);

	}

	@PostMapping("/updateEmployee")
	public boolean updateEmployee(String id, String fieldName, Object newValue) {

		InetAddress IP = InetAddress.getLocalHost();
		log.info("Updating Employee.");
		log.info("IP address: " + IP.getHostAddress() + "  Date: " + new Date());
		return service.updateEmployee(id, fieldName, newValue);

	}

}
