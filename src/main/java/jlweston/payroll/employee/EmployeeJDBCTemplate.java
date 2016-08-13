package jlweston.payroll.employee;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

//		This class holds a reference to the JDBC template
//		and carries out all database queries when the relevant
//		methods are invoked.

@RestController
public class EmployeeJDBCTemplate implements EmployeeDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String forename, String surname, String taxcode) {
		String SQL = "insert into Employees (forename, surname, taxcode) values (?, ?, ?)";

		jdbcTemplateObject.update( SQL, forename, surname, taxcode);
		System.out.println("Created Record Name = " + forename + " " + surname + ", Tax code = " + taxcode);
		return;
	}
	
	public void update(Integer id, String forename, String surname, String address1, String address2, String postcode, String taxcode) {
		String SQL = "update Employees (forename, surname, address1, address2, postcode, taxcode) values (?, ?, ?, ?, ?, ?) where employeeid = " + id;

		jdbcTemplateObject.update( SQL, forename, surname, address1, address2, postcode, taxcode);
		System.out.println("Updated Record Name = " + forename + " " + surname + ", Tax code = " + taxcode);
		return;
	}

	public Employee employeeFromID(Integer id) {
		String SQL = "select * from EMPLOYEES where EMPLOYEEID = ?";
		Employee Employee = jdbcTemplateObject.queryForObject(SQL, 
				new Object[]{id}, new EmployeeMapper());
		return Employee;
	}

	public List<Employee> listEmployees() {
		String SQL = "select * from EMPLOYEES";
		List<Employee> employees = jdbcTemplateObject.query(SQL, 
				new EmployeeMapper());
		return employees;
	}

	public void delete(Integer id){
		String SQL = "delete from EMPLOYEES where EMPLOYEEID = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with EMPLOYEEID = " + id );
		return;
	}
}