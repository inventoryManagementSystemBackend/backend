package com.keral.inventoryManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Sales")
@Entity
public class Sale {

	@Id
	@Column(name = "Sales_ID")
	private String sales_id;

	@Column(name = "Quantity_Sold")
	// private String quantitySold;

	@OneToOne
	private Product product;

}
