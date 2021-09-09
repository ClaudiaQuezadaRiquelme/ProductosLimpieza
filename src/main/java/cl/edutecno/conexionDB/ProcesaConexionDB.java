package cl.edutecno.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProcesaConexionDB {

	protected static Connection conn;
	protected PreparedStatement pstm = null;
	protected ResultSet rs = null;
	
	//EJEMPLO DE CONEXION transformado a singleton
	protected static void generaConexion() {
		// ORACLE
//		String usr = "TEST";
//		String pwd = "1234";
//		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@186.64.120.248:1521:ORCL18";
		
		// SQLite
		String driver = "org.sqlite.JDBC";
		String url = "jdbc:sqlite:/media/cklaholandia/DATOS/Documentos/talentoDigitalEdutecno2/M4_PruebaProductosLimpieza/pruebaProductosLimplieza.sqlite";
		
		try {
			Class.forName(driver);
//			conn = DriverManager.getConnection(url,usr,pwd); // ORACLE
			conn = DriverManager.getConnection(url); // SQLite
			System.out.println("conexión con singleton sin context.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection obtenerConexion() {
		if (conn == null) {
			generaConexion();
		}
		return conn;
	}
	
	//EJEMPLO DE CONEXION CON SINGLETON usando configuracion en el servidor
	protected Connection generaPoolConexion() {
		Context initContext;
		if (conn == null) {
			try {
				initContext = new InitialContext();
				DataSource ds = (DataSource) initContext.lookup("java:/comp/env/jdbc/ConexionSQLite");
				try {
					conn = ds.getConnection();
							System.out.println("CREACION DE CONEXION CON GetConnection");
							System.out.println("conexión con singleton");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}System.out.println("Ya hay una conexion");
		return conn;
	}
}
