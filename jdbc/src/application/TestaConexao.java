package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jdbc.DB;

public class TestaConexao {

	public static void main(String[] args) throws IOException, SQLException {
		Connection conecta = DB.getConexao();
		
		System.out.println("Conectado");
		
		PreparedStatement sti = conecta.prepareStatement("insert into aluno(nome,sexo,dt_nasc)" + "values(?,?,?);");
		
		sti.setString(1, "alguem5");
		sti.setString(2, "Feminino");
		Calendar c = new GregorianCalendar(2000,0,2);
		sti.setDate(3, new Date(c.getTimeInMillis()));
		sti.executeUpdate();
		sti.close();
		
		Statement st = conecta.createStatement();
		
		String sql = "select * from aluno";
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+" " + rs.getString(2)+ " " + rs.getString(3) + " " + rs.getDate("dt_nasc"));
		}
		rs.close();
		st.close();
		DB.CloseConnection();
		
		System.out.println("Desconectado");
	}

}
