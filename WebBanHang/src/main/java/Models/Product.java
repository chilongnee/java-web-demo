package Models;

public class Product {
	private int id;
	private String name; // tên sản phẩm
	private double price; // giá sản phẩm
	private int quantity; // số lượng sản phẩm
	private String image; // hình ảnh sản phẩm
	
	// Constructors
	public Product() {
		super();
	}
	
	public Product(int id, String name, double price, int quantity, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	
	// Getters Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
