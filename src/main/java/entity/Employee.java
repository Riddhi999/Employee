package entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name = "EMPLOYEE_ID", nullable = false)
	private String employeeId;

	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Column(name = "CONTACT", nullable = false)
	private String employeeContact;

	@Column(name = "DESIGNATION", nullable = false)
	private String Designation;

	@Column(name = "START_DATE", nullable = false)
	private Date startDate;

	@Column(name = "DEPARTMENT", nullable = false)
	private String department;

	@Column(name = "STATUS", nullable = false)
	private String status;

	@Column(name = "END_DATE", nullable = false)
	private Date endDate;

	@Column(name = "MANAGER", nullable = false)
	private String manager;

	@Column(name = "GENDER", nullable = false)
	private String gender;

	@Column(name = "BLOOD_GROUP", nullable = false)
	private String bloodGroup;

	@Column(name = "ADDRESS", nullable = false)
	private String address;

	@OneToMany(mappedBy = "empl")
	private Set<Depandents> depandents;

	@OneToMany(mappedBy = "empl")
	private Set<Qualification> qualification;

}
