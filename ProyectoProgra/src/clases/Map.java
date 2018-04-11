package clases;

import java.util.Hashtable;

public class Map {
	
	private Hashtable<Integer, Object> map;
	
	public Map() {
		map = new Hashtable<>();
	}
	
	public boolean contains(int key) {
		return map.containsKey(key);
	}
	
	public boolean add(int key, Object o) {
		map.put(key, o);
		return true;
	}
	
	public Object get(int key) {
		return map.get(key);
	}
	
	public int size() {
		return map.size();
	}
}
