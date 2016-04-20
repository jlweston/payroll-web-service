package payrollDB;

import java.util.List;
import javax.sql.DataSource;

public interface PaymentTypeDAO {
	/** 
	 * This method will initialise the database connection.
	 */
	public void setDataSource(DataSource ds);
	/** 
	 * Method to create a PaymentType.
	 */
	public void create(String name, String rate);
	/** 
	 * Method to retrieve a single PaymentType.
	 */
	public PaymentType getPaymentType(Integer id);
	/** 
	 * Method to return all PaymentType objects.
	 */
	public List<PaymentType> listPaymentTypes();
	/** 
	 * Method to delete a single PaymentType given an employee id.
	 */
	public void delete(Integer id);
}