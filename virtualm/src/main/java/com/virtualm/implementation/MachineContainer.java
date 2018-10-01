package com.virtualm.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MachineContainer<T> {
	private Map<T, Integer> container = new HashMap<T, Integer>();

	public int getQuantity(T item) {
		Integer value = container.get(item);
		return value == null ? 0 : value;
	}

	public void add(T item) {
		int count = container.get(item);
		container.put(item, count + 1);
	}

	public void deduct(T item) {
		if (hasItem(item)) {
			int count = container.get(item);
			container.put(item, count - 1);
		}
	}

	public boolean hasItem(T item) {
		return getQuantity(item) > 0;
	}
	
	public List<T> getContainerElements(){
		List<T> list = new ArrayList<T>(container.keySet());
		return list;
	}

	public void clear() {
		container.clear();
	}

	public void put(T item, int quantity) {
		container.put(item, quantity);
	}

}
