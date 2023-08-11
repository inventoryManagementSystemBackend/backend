package com.keral.inventoryManagementSystem.model;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = "product_id") 
@ToString(exclude = "product_id") 
@Table(name = "Products")
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long product_id;

	@Column(name = "Product_Name")
	private String product_name;

	@Column(name = "Category")
	private String category;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Product_Price")
	private double price;

	
}
