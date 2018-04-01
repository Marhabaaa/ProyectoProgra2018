package clases;

import java.sql.Connection;
import java.sql.SQLException;

import BDconnector.MySQLconnection;

public class Main {

	static MySQLconnection conn;
	public static void main(String[] args) throws SQLException {
		conn = new MySQLconnection();
		Connection inv = conn.getConnection();
		
		System.out.println(inv.getClientInfo());
	}
}
