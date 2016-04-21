package payrollDB;

import java.util.List;
import javax.sql.DataSource;

public interface PaymentHistoryDAO {
	/** 
	 * This method will initialise the database connection.
	 */
	public void setDataSource(DataSource ds);
	/** 
	 * Method to create a PaymentHistory entry.
	 */
	public void create(Integer employeeid, Integer paymentid, Integer paymentperiod, String rate);
	/** 
	 * Method to return all PaymentHistory objects.
	 */
	public List<PaymentHistory> listPaymentHistory();
	/** 
	 * Method to return all PaymentHistory objects for an employee given the id.
	 */
	public List<PaymentHistory> listPaymentHistory(Integer id);
	/** 
	 * Method to delete a single PaymentHistory object given an id.
	 */
	public void delete(Integer id);
}