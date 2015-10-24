package in.spring4buddies.application.beans;

public class SpringRefBean {

	private String idRefBean;
	public SpringRefBean() {
		System.out.println("(constructor) SpringFooBean()");
	}

	public void foo() {
		System.out.println("foo()");
	}

	@Override
	public String toString() {
		return "SpringFooBean-ref";
	}

	public String getIdRefBean() {
		return idRefBean;
	}

	public void setIdRefBean(String idRefBean) {
		this.idRefBean = idRefBean;
	}
	
	
}
