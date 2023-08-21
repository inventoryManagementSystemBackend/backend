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
import lombok.Getter;
import lombok.Setter;

@Data
@Table(name = "Orders")
@Entity
@Getter
@Setter
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



	
	

}
