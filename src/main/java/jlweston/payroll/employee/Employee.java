package jlweston.payroll.employee;

public class Employee {
	private Integer id;
	private String forename;
	private String surname;
	private String address1;
	private String address2;
	private String postcode;
	private String taxcode;


	public void setForename(String forename) {
		this.forename = forename;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	/**
	 * @return Address line 1
	 */
	 public String getAddress1() {
		 return address1;
	 }

	 /**
	  * @param address1 Sets address line 2
	  */
	 public void setAddress1(String address1) {
		 this.address1 = address1;
	 }

	 /**
	  * @return Address line 1
	  */
	 public String getAddress2() {
		 return address2;
	 }

	 /**
	  * @param address2 Sets address line 2
	  */
	 public void setAddress2(String address2) {
		 this.address2 = address2;
	 }

	 /**
	  * @return the postcode
	  */
	 public String getPostcode() {
		 return postcode;
	 }

	 /**
	  * @param postcode the postcode to set
	  */
	 public void setPostcode(String postcode) {
		 this.postcode = postcode;
	 }

	 /**
	  * @return the taxcode
	  */
	 public String getTaxcode() {
		 return taxcode;
	 }

	 /**
	  * @param taxcode the taxcode to set
	  */
	 public void setTaxcode(String taxcode) {
		 this.taxcode = taxcode;
	 }
}