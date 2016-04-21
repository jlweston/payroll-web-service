package payrollDB;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentHistoryController {
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("Beans.xml");

	PaymentHistoryJDBCTemplate paymenthistoryJDBCTemplate = 
			(PaymentHistoryJDBCTemplate)context.getBean("PaymentHistoryJDBCTemplate");

	//	Retrieves all PaymentHistory.
	@RequestMapping(value="/paymenthistory", method=RequestMethod.GET)
	public List<PaymentHistory> listPaymentHistory() {
		List<PaymentHistory> paymentthistory = paymenthistoryJDBCTemplate.listPaymentHistory();
		return paymentthistory;
	}
}