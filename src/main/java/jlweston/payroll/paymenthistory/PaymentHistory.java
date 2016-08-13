package jlweston.payroll.paymenthistory;

public class PaymentHistory {
	private Integer id;
	private Integer employeeid;
	private String forename;
	private String surname;
	private Integer payperiod;
	private String paymentname;
	private Integer paymentrate;
	private Integer paymentid;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer id) {
		this.employeeid = id;
	}
	public String getForename() {
		return forename;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getPayperiod() {
		return payperiod;
	}
	public void setPayperiod(Integer payperiod) {
		this.payperiod = payperiod;
	}
	public String getPaymentname() {
		return paymentname;
	}
	public void setPaymentname(String paymentname) {
		this.paymentname = paymentname;
	}
	public Integer getPaymentrate() {
		return paymentrate;
	}
	public void setPaymentrate(Integer paymentrate) {
		this.paymentrate = paymentrate;
	}
	public Integer getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Integer paymentid) {
		this.paymentid = paymentid;
		
	}
}