package jlweston.payroll.employee;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://jlweston.redirectme.net:8080")
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

	//	Mapping for '/employee/' [POST].
	//	Creates a single Employee based on the parameters provided.
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public void createEmployee(@RequestParam() String forename,
			@RequestParam() String surname,
			@RequestParam() String taxcode) {
		employeeJDBCTemplate.create(forename, surname, taxcode);
	}
	
	//	Mapping for '/employee/{id}' [PUT].
	//	Updates a single Employee based on the parameters provided.
	@RequestMapping(value="/employee/{id}", method=RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String updateEmployee(@RequestParam(required = false) Integer id, @RequestBody Employee employee) {
		System.out.println("POST request received for employee: " + id);
		employeeJDBCTemplate.update(id, employee);
		return new String("");
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