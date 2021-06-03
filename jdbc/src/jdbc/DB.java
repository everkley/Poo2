package jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection conexao;
	
	public static Properties getPropriedades() throws IOException {
		Properties propriedade = new Properties();
		FileInputStream file = new FileInputStream("./propriedades/db.properties");
		propriedade.load(file);
		return propriedade;
	}
	
	
	
	public static Connection getConexao() throws IOException, SQLException{
		String host;
		String user;
		String pass;		
		Properties p = DB.getPropriedades();
		host = p.getProperty("host");
		user = p.getProperty("user");
		pass = p.getProperty("password");
		
		conexao = DriverManager.getConnection(host,user,pass);
		return conexao;
	}
	
	public static void CloseConnection() throws SQLException {
		if(conexao != null) {
			conexao.close();
		}
	}
}
