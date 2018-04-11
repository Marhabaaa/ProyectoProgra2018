package clases;

import java.util.ArrayList;

public class PartsList {
	private ArrayList<Pieza> partsList;
	
	public PartsList() {
		partsList = new ArrayList<>();
	}
	
	public void addPart(Pieza part) {
		partsList.add(part);
	}
}
