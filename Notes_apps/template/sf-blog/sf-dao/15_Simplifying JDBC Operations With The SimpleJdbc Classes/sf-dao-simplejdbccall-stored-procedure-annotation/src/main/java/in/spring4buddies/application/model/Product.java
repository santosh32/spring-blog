package in.spring4buddies.application.model;

public class Product {

	private int productId;
	private String name;
	private int price;
	private String brand;

	public Product() {

	}

	public Product(int productId, String name, int price, String brand) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String productName) {
		this.name = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + name + ", price=" + price + ", brand=" + brand + "]";
	}

}