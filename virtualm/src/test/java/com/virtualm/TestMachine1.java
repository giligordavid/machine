package com.virtualm;

import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;
import com.virtualm.implementation.Cart;
import com.virtualm.implementation.MachineImpl;

public class TestMachine1 {

	public static void main(String[] args) {
		MachineImpl vm = new MachineImpl();

		vm.insertCoin(Coins.QUARTER);
		vm.insertCoin(Coins.DIME);
		vm.insertCoin(Coins.DIME);
		vm.insertCoin(Coins.QUARTER);
		System.out.println("Egyenleg: " + vm.getActualBalance());

		long price = vm.selectItemAndGetPrice(Product.COKE);
		System.out.println("Price of COKE: " + price);

		Product product1 = vm.getProduct();
		System.out.println("Kiadott termék: " + product1.getName());
		System.out.println("Egyenleg: " + vm.getActualBalance());

		long price2 = vm.selectItemAndGetPrice(Product.PEPSI);
		System.out.println("Price of PEPSI: " + price2);

		Cart cart1 = vm.getProductAndMoney();
		System.out.println("Kiadott termék: " + cart1.getProduct().getName());
		System.out.println("Visszajáró érmék: ");
		for (Coins coin : cart1.getChange()) {
			System.out.println(coin.getValue());
		}
		System.out.println("Egyenleg: " + vm.getActualBalance());

		System.out.println("Gép termék lista: ");
		for (Product product : vm.machineAvailableProductList()) {
			System.out.println(product.getName());
		}

		System.out.println("Gép érme lista: ");
		for (Coins coin : vm.machineAvailableCoinList()) {
			System.out.println(coin.getValue());
		}

	}

}
