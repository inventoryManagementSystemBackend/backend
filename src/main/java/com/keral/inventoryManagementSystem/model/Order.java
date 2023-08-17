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
@Table(name = "Orders")
@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Order_ID")
	private long Order_id;
	
	@Column(name = "Order_Number")
	private long orderNumber;

	@OneToOne
	private Supplier supplier;

	@OneToOne
	@JoinColumn(name = "product_id" , nullable = false)
	private Product product;

	public String getOrder_id() {
		return Order_id;
	}

	public void setOrder_id(String order_id) {
		Order_id = order_id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
