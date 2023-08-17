package com.keral.inventoryManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(exclude = "supplier_id") 
@ToString(exclude = "supplier_id") 
@Data
@Table(name = "Supplier")
@Entity
public class Supplier {
	//
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Supplier_ID")
	private Long supplier_id;
	@Column(name = "Supplier_Name")
	private String supplier_name;
	
	public Long getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}
	

}
