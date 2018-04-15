package clases;

import java.io.IOException;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		
		SistemaServicioTecnico B = new SistemaServicioTecnico();
		
		Report r = new Report();
		SList list = B.getOrdersMap().toSList();
		
		r.ganaciasTotales(list);
		
		//int i = 0;
		
		//B.showTest(1);
		/*SList list = (SList) B.getStockMap().toSList();
		
		while(i < list.size()) {
			System.out.println("Descripcion: " + ((Pieza) list.get(i)).getDescription());
			i++;
		}*/
	}
}
