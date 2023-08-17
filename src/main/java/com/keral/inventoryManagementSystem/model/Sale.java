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

	//@Column(name = "Quantity_Sold")
	// private String quantitySold;

	@OneToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

}
