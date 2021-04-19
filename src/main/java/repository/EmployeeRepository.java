package repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
	public Employee findById(String id);
	public Employee findByEmployeeId(String id);

}
