package clases;

import java.util.Hashtable;

public class StockMap {
	private Hashtable<Integer, Pieza> stockMap;

	public StockMap() {
		stockMap = new Hashtable<>();
	}
	
	public void addPart(Pieza part) {
		stockMap.put(part.getCode(), part);
	}
}
