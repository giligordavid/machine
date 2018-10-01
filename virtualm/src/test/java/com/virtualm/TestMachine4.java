package com.virtualm;


import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;
import com.virtualm.implementation.MachineImpl;

public class TestMachine4 {

	public static void main(String[] args) {
		MachineImpl vm = new MachineImpl();

		vm.insertCoin(Coins.NICKLE);
		System.out.println("Egyenleg: " + vm.getActualBalance());
		
		long price = vm.selectItemAndGetPrice(Product.COKE);
		System.out.println("Price of COKE: " + price);

		Product product1 = vm.getProduct();
		System.out.println("Kiadott termék: " + product1.getName());
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
