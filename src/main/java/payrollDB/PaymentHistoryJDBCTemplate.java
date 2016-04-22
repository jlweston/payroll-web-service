package payrollDB;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

//		This class holds a reference to the JDBC template
//		and carries out all database queries when the relevant
//		methods are invoked.

@RestController
public class PaymentHistoryJDBCTemplate implements PaymentHistoryDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void create(Integer employeeid, Integer paymentid, Integer paymentperiod, String rate) {
		// TODO implement a method to create a PaymentHistory object
	}

	public void delete(Integer id){
		String SQL = "delete from PAYMENTHISTORY where ID = ?";
		jdbcTemplateObject.update(SQL, id);
	}
	
	// Returns a list of all PaymentHistory items.
	@Override
	public List<PaymentHistory> listPaymentHistory() {
		String SQL = "SELECT * FROM employees LEFT JOIN (paymenthistory, paymenttype) "
				+ "ON (employees.employeeid = paymenthistory.employeeid AND paymenthistory.paymentid = paymenttype.paymentid)";
		List<PaymentHistory> paymenthistory = jdbcTemplateObject.query(SQL, 
				new PaymentHistoryMapper());
		return paymenthistory;		
	}
	
	// Returns a list of all PaymentHistory items for a particular employee
	// given an {id}.
	@Override
	public List<PaymentHistory> listPaymentHistory(Integer id) {
		String SQL = "SELECT * FROM employees LEFT JOIN (paymenthistory, paymenttype) ON (employees.employeeid = paymenthistory.employeeid AND paymenthistory.paymentid = paymenttype.paymentid) WHERE employees.employeeid = ?;";
		List<PaymentHistory> paymenthistory = jdbcTemplateObject.query(SQL, new Object[]{id},
				new PaymentHistoryMapper());
		return paymenthistory;		
	}
}