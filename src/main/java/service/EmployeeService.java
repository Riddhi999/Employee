package service;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Employee;
import lombok.extern.slf4j.Slf4j;
import repository.EmployeeRepository;

@Service
@Slf4j
public class EmployeeService {

	@Resource
	EmployeeRepository employeeRepository;

	public Employee fetchEmployee(String id) {

		if (id == null || id.equalsIgnoreCase("null") || id.isEmpty()) {
			// log.info("Employee id is null");
			return null;
		}
		Employee employee;

		try {
			// fetching the employee details from database
			employee = employeeRepository.findById(id);
			// log.info("Employee details fetched successfully");

		} catch (Exception e) {

			employee = new Employee();
		}

		return employee;
	}

	/**
	 * This method is used to save the new employee details into database
	 * 
	 * @param emp
	 * @return true if there is no exception while saving the object
	 */
	public boolean saveEmployee(Employee emp) {
		try {
			employeeRepository.save(emp);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/**
	 * This method is used to delete a employee based on the employee id
	 * 
	 * @param id
	 * @return true if and only if the deletion is successful with any exception.
	 */
	public boolean deleteEmployee(String id) {

		try {
			employeeRepository.delete(employeeRepository.findByEmployeeId(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * This method is used to update an existing employee information into database
	 * table
	 * 
	 * @param field
	 * @param newValue
	 * @return
	 */

	public boolean updateEmployee(String id, String field, Object newValue) {

		try {
			Employee emp = employeeRepository.findById(id);
			PropertyDescriptor property = new PropertyDescriptor(field, emp.getClass());
			Method method = property.getWriteMethod();
			method.invoke(emp, newValue);
			employeeRepository.save(emp);
			return true;

		} catch (Exception e) {
			log.info("Exception Ocuured " + e);
		}
	}

}
