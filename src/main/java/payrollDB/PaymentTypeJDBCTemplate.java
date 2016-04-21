package payrollDB;

import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;

//		This class holds a reference to the JDBC template
//		and carries out all database queries when the relevant
//		methods are invoked.

@RestController
public class PaymentTypeJDBCTemplate implements PaymentTypeDAO {

	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	// TODO confirm this correctly creates a new record when PUT used.
	public void create(String name, String rate) {
		String SQL = "insert into paymenttype (paymentname, defaultrate) values (?, ?)";

		jdbcTemplateObject.update( SQL, name, rate);
		System.out.println("Created Record Name = " + name + ", Rate = " + rate);
		return;	
	}
	
	public PaymentType getPaymentType(Integer id) {
		String SQL = "select * from PAYMENTTYPE where PAYMENTID = ?";
		PaymentType paymenttype = jdbcTemplateObject.queryForObject(SQL, 
				new Object[]{id}, new PaymentTypeMapper());
		return paymenttype;
	}

	public List<PaymentType> listPaymentTypes() {
		String SQL = "select * from PAYMENTTYPE";
		List<PaymentType> paymenttypes = jdbcTemplateObject.query(SQL, 
				new PaymentTypeMapper());
		return paymenttypes;
	}

	public void delete(Integer id){
		String SQL = "delete from PAYMENTTYPE where ID = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with PAYMENTID = " + id );
		return;
	}
}