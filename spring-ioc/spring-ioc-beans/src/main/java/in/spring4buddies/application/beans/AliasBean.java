package in.spring4buddies.application.beans;

public class AliasBean {

	private InnerRefBean innerRefBean;

	public AliasBean() {
		System.out.println("(constructor) AliasBean()");
	}

	public void alias() {
		System.out.println("alias()");
	}

	@Override
	public String toString() {
		return innerRefBean.toString();
	}

	public InnerRefBean getInnerRefBean() {
		return innerRefBean;
	}

	public void setInnerRefBean(InnerRefBean innerRefBean) {
		this.innerRefBean = innerRefBean;
	}

}
