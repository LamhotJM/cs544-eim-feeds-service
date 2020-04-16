package miu.group3.api.documents;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String id;
	private String productNumber;
	private String title;
	private String summary;
	private String description;
    private double discount;
	private double price;
	private LocalDate date = LocalDate.now();
	private int qtyAvail;
	private boolean isAvailable = true;
	private String imageUrl;
//	private String category;
//	private String merchant;
//	private String images;
//	
	Product(){};
	
	public Product(String productNumber, String title, String summary, String description, double discount,
			double price, int qtyAvail, boolean isAvailable, String imageUrl) {
		this.productNumber = productNumber;
		this.title = title;
		this.summary = summary;
		this.description = description;
		this.discount = discount;
		this.price = price;
		this.qtyAvail = qtyAvail;
		this.isAvailable = isAvailable;
		this.imageUrl = imageUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQtyAvail() {
		return qtyAvail;
	}
	public void setQtyAvail(int qtyAvail) {
		this.qtyAvail = qtyAvail;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", title=" + title + ", summary=" + summary
				+ ", description=" + description + ", discount=" + discount + ", price=" + price + ", date=" + date
				+ ", qtyAvail=" + qtyAvail + ", isAvailable=" + isAvailable + ", imageUrl=" + imageUrl + "]";
	}
	
	
	
}
