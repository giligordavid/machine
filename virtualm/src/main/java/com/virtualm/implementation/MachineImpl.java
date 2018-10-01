package com.virtualm.implementation;

import java.util.ArrayList;
import java.util.List;

import com.virtualm.api.Machine;
import com.virtualm.enums.Coins;
import com.virtualm.enums.Product;
import com.virtualm.exception.OwnException;

public class MachineImpl implements Machine {

	private long balance;
	private Product currentProduct;
	private MachineContainer<Coins> cashContainer = new MachineContainer<Coins>();
	private MachineContainer<Product> productContainer = new MachineContainer<Product>();

	public long selectItemAndGetPrice(Product product) {
		if (productContainer.hasItem(product)) {
			currentProduct = product;
			return currentProduct.getPrice();
		}
		throw new OwnException("Elfogyott! Válaszon másik terméket");

	}

	public void insertCoin(Coins coin) {
		balance = balance + coin.getValue();
		cashContainer.add(coin);

	}

	public MachineImpl() {
		initialize();
	}

	private Product collectItem() throws OwnException {
		if (isHasEnoughMoney()) {
			if (hasSufficientChange()) {
				productContainer.deduct(currentProduct);
				balance -= currentProduct.getPrice();
				return currentProduct;
			}
			throw new OwnException("Nincs váltópénz a gépben nem tud vissza adni");
		}
		throw new OwnException("Nem dobott be elég pénzt az automatába");
	}

	public boolean isHasEnoughMoney() {
		if (balance >= currentProduct.getPrice()) {
			return true;

		}
		return false;
	}

	private void initialize() {
		for (Coins c : Coins.values()) {
			cashContainer.put(c, 10);
		}
		for (Product i : Product.values()) {
			productContainer.put(i, 10);
		}

	}

	private List<Coins> refund() {
		List<Coins> refund = getChange(balance);
		updateCashContainer(refund);
		balance = 0;
		currentProduct = null;
		return refund;

	}

	public Cart getProductAndMoney() throws OwnException {
		Product product = collectItem();
		List<Coins> change = refund();
		Cart actualCart = new Cart(product, change);
		return actualCart;
	}

	private boolean hasSufficientChange() {
		return hasSufficientChangeForAmount(balance - currentProduct.getPrice());
	}

	private void updateCashContainer(List<Coins> change) {
		for (Coins c : change) {
			cashContainer.deduct(c);
		}
	}

	private List<Coins> getChange(long amount) throws OwnException {
		List<Coins> changes = new ArrayList<Coins>();

		long restAmount = amount;
		while (restAmount != 0) {
			if (restAmount >= Coins.QUARTER.getValue() && cashContainer.hasItem(Coins.QUARTER)) {
				changes.add(Coins.QUARTER);
				restAmount -= Coins.QUARTER.getValue();
				continue;
			} else if (restAmount >= Coins.DIME.getValue() && cashContainer.hasItem(Coins.DIME)) {
				changes.add(Coins.DIME);
				restAmount -= Coins.DIME.getValue();
				continue;
			} else if (restAmount >= Coins.NICKLE.getValue() && cashContainer.hasItem(Coins.NICKLE)) {
				changes.add(Coins.NICKLE);
				restAmount -= Coins.NICKLE.getValue();
				continue;
			} else if (restAmount >= Coins.PENNY.getValue() && cashContainer.hasItem(Coins.PENNY)) {
				changes.add(Coins.PENNY);
				restAmount -= Coins.PENNY.getValue();
				continue;
			} else {
				throw new OwnException("Nincs megfelelő visszajáró a gépben");
			}
		}
		return changes;

	}


	private boolean hasSufficientChangeForAmount(long amount) {
		boolean hasChange = true;
		try {
			getChange(amount);
		} catch (OwnException nsce) {
			return hasChange = false;
		}
		return hasChange;
	}

	public Product getProduct() {
		Product product = collectItem();
		return product;
	}
	
	public void resetMachine() {
		cashContainer.clear();
		productContainer.clear();
		currentProduct = null;
		balance = 0;
	}

	public List<Coins> resetOrder() {
		List<Coins> change = refund();
		currentProduct = null;
		balance = 0;
		return change;
	}

	public List<Product> machineAvailableProductList() {
		
		return productContainer.getContainerElements();
	}

	public List<Coins> machineAvailableCoinList() {
		return cashContainer.getContainerElements();
	}

	public long getActualBalance() {
		
		return balance;
	}

}
