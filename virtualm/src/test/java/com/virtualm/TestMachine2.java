package com.virtualm;

import java.util.List;

import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;
import com.virtualm.implementation.MachineImpl;

public class TestMachine2 {

	public static void main(String[] args) {
		MachineImpl vm = new MachineImpl();

		vm.insertCoin(Coins.QUARTER);
		vm.insertCoin(Coins.DIME);
		vm.insertCoin(Coins.DIME);
		vm.insertCoin(Coins.QUARTER);
		System.out.println("Egyenleg: " + vm.getActualBalance());
		System.out.println("Rendelés visszavonva! Visszajáró érmék: ");
		List<Coins> refuseCoins = vm.resetOrder();
		for (Coins coin : refuseCoins) {
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
