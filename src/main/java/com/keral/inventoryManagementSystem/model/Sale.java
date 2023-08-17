package com.keral.inventoryManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Sales")
@Entity
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Sales_ID")
	private String sales_id;
  
	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

	public Long getSale_id() {
		return sale_id;
	}

	public void setSale_id(Long sale_id) {
		this.sale_id = sale_id;
	}

	public String getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(String quantitySold) {
		this.quantitySold = quantitySold;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	

}
