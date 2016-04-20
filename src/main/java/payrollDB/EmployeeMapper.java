package payrollDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {
   public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
      Employee employee = new Employee();
      employee.setId(rs.getInt("EMPLOYEEID"));
      employee.setForename(rs.getString("Forename"));
      employee.setSurname(rs.getString("Surname"));
      employee.setAddress1(rs.getString("Address1"));
      employee.setAddress2(rs.getString("Address2"));
      employee.setPostcode(rs.getString("Postcode"));
      employee.setTaxcode(rs.getString("TaxCode"));
      return employee;
   }
}