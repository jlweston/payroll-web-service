package jlweston.payroll.paymenthistory;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://jlweston.redirectme.net:8080")
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
	
	@RequestMapping(value="/paymenthistory/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		paymenthistoryJDBCTemplate.delete(id);
	}
	
	@RequestMapping(value="/employee/{id}/paymenthistory", method=RequestMethod.GET)
	public List<PaymentHistory> listPaymentHistory(@PathVariable("id") Integer id) {
		List<PaymentHistory> paymentthistory = paymenthistoryJDBCTemplate.listPaymentHistory(id);
		return paymentthistory;
	}
	
	
}