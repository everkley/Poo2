package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	
	Connection con;
	String sql;
	PreparedStatement pst;
	
	
	public void salvar(Aluno a) throws IOException {
		
		try {
			Connection con = DB.getConexao();
			System.out.println("Conexão realizada com sucesso !");
			
			sql = "INSERT INTO aluno (nome, sexo, dt_nasc) VALUES ( ?,  ?, ?)";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno realizado com sucesso!");
			
			DB.CloseConnection();
			System.out.println("Conexão fechada com sucesso !");
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
	
	public List<Aluno> listar() throws IOException {
		List alunos = new ArrayList<Aluno>();
		try {
			Connection con = DB.getConexao();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from aluno");
			while(rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setSexo(rs.getString("sexo"));
				aluno.setDt_nasc(rs.getDate("dt_nasc"));
				alunos.add(aluno);
				
			}
			
			DB.CloseConnection();
			st.close();
			rs.close();
			return alunos;
		}catch(SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void apagar(int id) throws IOException {
		try {
			Connection connection = DB.getConexao();
			PreparedStatement st = connection.prepareStatement("delete from aluno where id=?");
			st.setInt(1, id);
			st.executeUpdate();
			System.out.println("Aluno excluido com sucesso");
			st.close();
			DB.CloseConnection();
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	public void alterar(Aluno a) throws IOException, SQLException {
		try {
		Connection connection = DB.getConexao();
		PreparedStatement st = connection.prepareStatement("update aluno set nome=?, sexo=?, dt_nasc=? where id=?");
		st.setString(1, a.getNome());
		st.setString(2, a.getSexo());
		Date dataSql = new Date(a.getDt_nasc().getTime());
		st.setDate(3, dataSql);
		st.setInt(4, a.getId());
		st.executeUpdate();
		st.close();
		DB.CloseConnection();
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
}

