package clases;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		SistemaServicioTecnico B = new SistemaServicioTecnico();
		
		int i = 0;
		
		//B.showTest(1);
		SList list = (SList) B.getStockMap().toSList();
		
		while(i < list.size()) {
			System.out.println("Descripcion: " + ((Pieza) list.get(i)).getDescription());
			i++;
		}
	}
}
