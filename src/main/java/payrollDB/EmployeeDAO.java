package payrollDB;

import java.util.List;
import javax.sql.DataSource;

public interface EmployeeDAO {
   /** 
    * This method will initialise the database connection.
    */
	
   public void setDataSource(DataSource ds);
   /** 
    * Method to create an Employee.
    */
   public void create(String forename, String surname, String taxcode);
   /** 
    * Method to retrieve a single Employee.
    */
   public Employee employeeFromID(Integer id);
   /** 
    * Method to return all Employee objects.
    */
   public List<Employee> listEmployees();
   /** 
    * Method to delete a single Employee given an employee id.
    */
   public void delete(Integer id);
}