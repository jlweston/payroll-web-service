package jlweston.payroll.paymenttype;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PaymentTypeMapper implements RowMapper<PaymentType> {
   public PaymentType mapRow(ResultSet rs, int rowNum) throws SQLException {
      PaymentType paymenttype = new PaymentType();
      paymenttype.setId(rs.getInt("PAYMENTID"));
      paymenttype.setName(rs.getString("PAYMENTNAME"));
      paymenttype.setDefaultrate(rs.getInt("DEFAULTRATE"));
      paymenttype.setTaxable(rs.getInt("TAXABLE"));
      paymenttype.setNiable(rs.getInt("NIABLE"));
      paymenttype.setBik(rs.getInt("BIK"));
      return paymenttype;
   }
}