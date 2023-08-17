package com.keral.inventoryManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Supplier")
@Entity
public class Supplier {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Supplier_ID")
	private String supplier_id;
	@Column(name = "Supplier_Name")
	private String supplier_name;
	
}
