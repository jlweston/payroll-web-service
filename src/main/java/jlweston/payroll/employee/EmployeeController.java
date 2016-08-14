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
public class EmployeeController {
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("Beans.xml");

	EmployeeJDBCTemplate employeeJDBCTemplate = 
			(EmployeeJDBCTemplate)context.getBean("EmployeeJDBCTemplate");

	//	Mapping for '/employee/' [GET].
	//	Retrieves all Employees.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeJDBCTemplate.listEmployees();
		return employees;
	}

	//	Mapping for '/employee/' [PUT].
	//	Creates a single Employee based on the parameters provided.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/employee", method=RequestMethod.PUT)
	public void createEmployee(@RequestParam() String forename,
			@RequestParam() String surname,
			@RequestParam() String taxcode) {
		employeeJDBCTemplate.create(forename, surname, taxcode);
	}
	
	//	Mapping for '/employee/{id}' [POST].
	//	Creates a single Employee based on the parameters provided.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/employee/{id}", method=RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String updateEmployee(@RequestParam(required = false) Integer id, @RequestBody Employee employee) {
		System.out.println("POST request received for employee: " + id);
		employeeJDBCTemplate.update(id, employee);
		return new String("");
	}
	
//	public void updateEmployee(@PathVariable("id") Integer id, 
//			@RequestParam() String forename,
//			@RequestParam() String surname,
//			@RequestParam() String address1,
//			@RequestParam() String address2,
//			@RequestParam() String postcode,
//			@RequestParam() String taxcode) {
//		employeeJDBCTemplate.update(id, forename, surname, address1, address2, postcode, taxcode);
//	}

	//	Mapping for '/employee/' [DELETE]
	//	Deletes a single Employee based on the id provided.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		employeeJDBCTemplate.delete(id);
	}

	//	Mapping for '/employee/{id}' [GET].
	//	Retrieves a single Employee based on the id provided.
	@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/employee/{id}", method=RequestMethod.GET)
	public Employee employeeFromID(@PathVariable("id") Integer id) {
		Employee employee = employeeJDBCTemplate.employeeFromID(id);
		return employee;
	}

}