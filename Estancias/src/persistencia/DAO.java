package persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public abstract class DAO {
	protected Connection conexion = null;
	protected ResultSet resultSet = null;
	protected Statement statement = null;

	private final String HOST = obtenerCredencial("config.host");
	private final String PORT = obtenerCredencial("config.port");
	private final String USER = obtenerCredencial("config.user");
	private final String PASS = obtenerCredencial("config.password");
	private final String DB = obtenerCredencial("config.database");
	private final String DRIVER = "com.mysql.cj.jdbc.Driver";

	private String obtenerCredencial(String credencial) {
		Properties props = new Properties();
		
		try (FileInputStream input = new FileInputStream("config.properties")) {
			props.load(input);
			
		} catch (IOException e) {
			System.out.println("Error al cargar las credenciales de la base de datos: " + e.getMessage());
			return null;
		}

		return props.getProperty(credencial);
	}
	
	protected void conectarDataBase() throws SQLException, ClassNotFoundException {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	protected void desconectarDataBase() throws SQLException, ClassNotFoundException {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (conexion != null) {
				conexion.close();
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

	protected void insertarModificarEliminarDataBase(String sql) throws SQLException, ClassNotFoundException {
		try {
			conectarDataBase();
			statement = conexion.createStatement();
			statement.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;

		} finally {
			desconectarDataBase();
		}
	}

	protected void consultarDataBase(String sql) throws SQLException, ClassNotFoundException {
		try {
			conectarDataBase();
			statement = conexion.createStatement();
			resultSet = statement.executeQuery(sql);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
}
