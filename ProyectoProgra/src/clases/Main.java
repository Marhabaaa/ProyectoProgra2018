package clases;

import java.sql.*;
import java.util.Hashtable;

import BDconnector.MySQLconnection;

public class Main {

	static MySQLconnection conn;
	public static void main(String[] args) throws SQLException {
		
		SistemaServicioTecnico B = new SistemaServicioTecnico();
		
		B.showTest(1);	
	}
}
