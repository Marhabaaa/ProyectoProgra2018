package clases;

import java.util.ArrayList;

public class SList {
	private ArrayList<Object> list;
	
	public SList() {
		list = new ArrayList<>();
	}
	
	public boolean add(Object o) {
		list.add(o);
		return true;
	}
	
	public Object get(int index) {
		return list.get(index);
	}
	
	public int size() {
		return list.size();
	}
}