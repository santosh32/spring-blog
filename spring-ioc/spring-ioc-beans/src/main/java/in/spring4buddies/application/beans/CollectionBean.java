package in.spring4buddies.application.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {

	private SpringFooBean springFooBean;

	private List<Object> someList = new ArrayList<>();
	private Set<Object> someSet = new HashSet<>();
	private Map<String, Object> someMap = new HashMap<>();
	private Properties someProps = new Properties();

	public void setSomeList(List<Object> someList) {
		this.someList = someList;
	}

	public void setSomeSet(Set<Object> someSet) {
		this.someSet = someSet;
	}

	public void setSomeMap(Map<String, Object> someMap) {
		this.someMap = someMap;
	}

	public List<Object> getSomeList() {
		return someList;
	}

	public Set<Object> getSomeSet() {
		return someSet;
	}

	public Map<String, Object> getSomeMap() {
		return someMap;
	}

	public Properties getSomeProps() {
		return someProps;
	}

	public void setSomeProps(Properties someProps) {
		this.someProps = someProps;
	}

	public SpringFooBean getSpringFooBean() {
		return springFooBean;
	}

	public void setSpringFooBean(SpringFooBean springFooBean) {
		this.springFooBean = springFooBean;
	}

}
