package clases;

import java.sql.*;
import BDconnector.MySQLconnection;

public class Main {

	static MySQLconnection conn;
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
