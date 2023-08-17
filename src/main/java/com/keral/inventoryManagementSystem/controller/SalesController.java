package com.keral.inventoryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keral.inventoryManagementSystem.model.Sale;

import com.keral.inventoryManagementSystem.service.SalesManagementService;

@RestController
@RequestMapping("/inventory") 
public class SalesController {

	
	@Autowired
	private SalesManagementService inService;

	 @PostMapping("/sale")
	    public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
		  Sale savedSale = inService.save(sale);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedSale);
	    }

	    @GetMapping("/sales")
	    public ResponseEntity<List<Sale>> getAllSuppliers() {
	        try {
	            List<Sale> sales = inService.getAllSales();
	            return ResponseEntity.ok(sales);
	        } catch (Exception e) {
	            // Use a logging framework to log the exception
	            // Log.error("Error while fetching suppliers", e);
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	    }

	    @GetMapping("/sale/{id}")
	    public ResponseEntity<Sale> getSale(@PathVariable("id") long id) {
	    	Sale sale = inService.getSaleById(id);
	        if (sale != null) {
	            return ResponseEntity.ok(sale);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/sale/{id}")
	    public ResponseEntity<String> deleteSale(@PathVariable("id") long id) {
	        inService.deleteSaleById(id);
	        return ResponseEntity.ok("Sale successfully deleted");
	    }

	    @PostMapping("/sale/{id}")
	    public ResponseEntity<String> updateSale(@PathVariable("id") long id, @RequestBody Sale sale) {
	    	Sale updatedSale = inService.updateSale(id, sale);
	        if (updatedSale != null) {
	            return ResponseEntity.ok("Sale updated successfully");
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	


}

