package jlweston.payroll.employee;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class EmployeeController {
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("Beans.xml");

	EmployeeJDBCTemplate employeeJDBCTemplate = 
			(EmployeeJDBCTemplate)context.getBean("EmployeeJDBCTemplate");

	//	Mapping for '/employee/' [GET].
	//	Retrieves all Employees.
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeJDBCTemplate.listEmployees();
		return employees;
	}

	//	Mapping for '/employee/' [PUT].
	//	Creates a single Employee based on the parameters provided.
	@RequestMapping(value="/employee", method=RequestMethod.PUT)
	public void createEmployee(@RequestParam() String forename,
			@RequestParam() String surname,
			@RequestParam() String taxcode) {
		employeeJDBCTemplate.create(forename, surname, taxcode);
	}

	//	Mapping for '/employee/' [DELETE]
	//	Deletes a single Employee based on the id provided.
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		employeeJDBCTemplate.delete(id);
	}

	//	Mapping for '/employee/{id}' [GET].
	//	Retrieves a single Employee based on the id provided.
	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET)
	public Employee employeeFromID(@PathVariable("id") Integer id) {
		Employee employee = employeeJDBCTemplate.employeeFromID(id);
		return employee;
	}

}