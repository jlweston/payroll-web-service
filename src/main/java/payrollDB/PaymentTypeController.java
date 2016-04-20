package payrollDB;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentTypeController {
	ApplicationContext context = 
			new ClassPathXmlApplicationContext("Beans.xml");

	PaymentTypeJDBCTemplate paymenttypeJDBCTemplate = 
			(PaymentTypeJDBCTemplate)context.getBean("PaymentTypeJDBCTemplate");

	//	Retrieves all PaymentTypes.
	@RequestMapping(value="/paymenttype", method=RequestMethod.GET)
	public List<PaymentType> listPaymentTypes() {
		List<PaymentType> paymenttypes = paymenttypeJDBCTemplate.listPaymentTypes();
		return paymenttypes;
	}

	//	Creates a single PaymentType based on the parameters provided.
	@RequestMapping(value="/paymenttype", method=RequestMethod.PUT)
	public void createPaymentType(@RequestParam() String name,
			@RequestParam() String rate) {
		paymenttypeJDBCTemplate.create(name, rate);
	}

	//	Deletes a single PaymentType based on the id provided.
	@RequestMapping(value="/paymenttype/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Integer id) {
		paymenttypeJDBCTemplate.delete(id);
	}

	//	Retrieves a single PaymentType based on the id provided.
	@RequestMapping(value="/paymenttype/{id}", method=RequestMethod.GET)
	public PaymentType paymenttypeFromID(@PathVariable("id") Integer id) {
		PaymentType paymenttype = paymenttypeJDBCTemplate.getPaymentType(id);
		return paymenttype;
	}
}