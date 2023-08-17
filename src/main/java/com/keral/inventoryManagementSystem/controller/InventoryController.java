package com.keral.inventoryManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keral.inventoryManagementSystem.model.Product;
import com.keral.inventoryManagementSystem.service.InventoryManagementService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryManagementService inService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product p) {
		Product savedProduct = inService.save(p);
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@PostMapping("/produtsall")
    public List<Product> saveProducts(@RequestBody List<Product> products) {
        return inService.saveProducts(products);
    }

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = inService.getAllProducts();
		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public Product getMyProduct(@PathVariable("id") long id) {
		Product p = inService.productById(id);
		Product psave = inService.save(p);
		return psave;
	}

	@DeleteMapping("/products/{id}")
	public String deleteById(@PathVariable("id") long id) {
		inService.deleteById(id);
		return "Product is succesfully deleted";

	}
	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable("id") long id , Product product){
		inService.updateProduct(id, product);
		return "Product is updated succesfully";
	}

}
