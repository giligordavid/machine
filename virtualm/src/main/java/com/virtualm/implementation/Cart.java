package com.virtualm.implementation;

import java.util.List;

import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;

public class Cart {


	public Cart(Product product, List<Coins> change) {
		this.product = product;
		this.change = change;
	}

	private Product product;
	private List<Coins> change;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Coins> getChange() {
		return change;
	}

	public void setChange(List<Coins> change) {
		this.change = change;
	}
	
}
