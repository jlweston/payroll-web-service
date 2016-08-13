package jlweston.payroll.paymenthistory;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PaymentHistoryMapper implements RowMapper<PaymentHistory> {
   public PaymentHistory mapRow(ResultSet rs, int rowNum) throws SQLException {
      PaymentHistory paymenthistory = new PaymentHistory();
      paymenthistory.setId(rs.getInt("ID"));
      paymenthistory.setEmployeeid(rs.getInt("EMPLOYEEID"));
      paymenthistory.setForename(rs.getString("FORENAME"));
      paymenthistory.setSurname(rs.getString("SURNAME"));
      paymenthistory.setPayperiod(rs.getInt("PAYPERIOD"));
      paymenthistory.setPaymentid(rs.getInt("PAYMENTID"));
      paymenthistory.setPaymentname(rs.getString("PAYMENTNAME"));
      paymenthistory.setPaymentrate(rs.getInt("PAYMENTRATE"));
      return paymenthistory;
   }
}