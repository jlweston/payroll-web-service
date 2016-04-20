package payrollDB;

public class PaymentType {
	private Integer id;
	private String name;
	private Integer defaultrate;
	private Boolean taxable;
	private Boolean niable;
	private Boolean bik;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDefaultrate() {
		return defaultrate;
	}
	public void setDefaultrate(Integer defaultrate) {
		this.defaultrate = defaultrate;
	}
	public Boolean getTaxable() {
		return taxable;
	}
	public void setTaxable(Integer taxable) {
		if (taxable == 1){
			this.taxable = true;
		}	else	{
			this.taxable = false;
		}
	}
	public Boolean getNiable() {
		return niable;
	}
	public void setNiable(Integer niable) {
		if (niable == 1){
			this.niable = true;
		}	else	{
			this.niable = false;
		}
	}
	public Boolean getBik() {
		return bik;
	}
	public void setBik(Integer bik) {
		if (bik == 1){
			this.bik = true;
		}	else	{
			this.bik = false;
		}
	}

}