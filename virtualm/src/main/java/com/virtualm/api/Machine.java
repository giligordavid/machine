package com.virtualm.api;

import java.util.List;

import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;
import com.virtualm.implementation.Cart;

public interface Machine {

	public long selectItemAndGetPrice(Product product);

	public void insertCoin(Coins coin);

	public Cart getProductAndMoney();

	public void resetMachine();

	public Product getProduct();

	public long getActualBalance();

	public List<Coins> resetOrder();

	public List<Product> machineAvailableProductList();

	public List<Coins> machineAvailableCoinList();

}
