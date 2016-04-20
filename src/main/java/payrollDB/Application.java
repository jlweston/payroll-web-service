package payrollDB;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        @SuppressWarnings("resource")
		ApplicationContext context = 
                new ClassPathXmlApplicationContext("Beans.xml");
        
        EmployeeJDBCTemplate employeeJDBCTemplate = 
        	      (EmployeeJDBCTemplate)context.getBean("EmployeeJDBCTemplate");
        
        // confirm application running and SQL database available by outputting
        // query to console
        System.out.println("------Listing Multiple Records--------" );
        List<Employee> employees = employeeJDBCTemplate.listEmployees();
        for (Employee record : employees) {
           System.out.print("ID : " + record.getId() );
           System.out.print(", Forename : " + record.getForename() );
           System.out.println(", Surname : " + record.getSurname());
        }
    }
}
