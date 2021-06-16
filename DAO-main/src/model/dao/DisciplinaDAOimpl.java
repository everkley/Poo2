package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.db.DB;
import model.entities.Disciplina;

public class DisciplinaDAOimpl implements DisciplinaDAO {
	private Connection conexao;
	
	public DisciplinaDAOimpl(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Disciplina obj) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String SQL;
			SQL= "insert into disciplina (nomedisciplina, cargahoraria) values (?,?)";
			pst = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());
			

			int linhas = pst.executeUpdate();
				
			if (linhas > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next()) {
						obj.setIdDisciplina(rs.getInt(1));
				}
				System.out.println("    Disciplina [ " 
									+ obj.getIdDisciplina() + " | " 
									+ obj.getNomedisciplina() + " ] "
									+ " foi criado com sucesso!");
			}
			else {
				System.out.println("    Não foi possível cadastrar a Disciplina!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		//executado mesmo se cair no catch
		finally { 
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}
		
	}

	@Override
	public void alterar(Disciplina obj) {
		PreparedStatement pst = null;
		try {
			String SQL;
			SQL= "update disciplina set nomedisciplina = ?, cargahoraria =? where iddisciplina = ?";
			pst = conexao.prepareStatement(SQL);
			pst.setString(1, obj.getNomedisciplina());
			pst.setInt(2, obj.getCargahoraria());
			pst.setInt(3, obj.getIdDisciplina());
			
			int linhas = pst.executeUpdate();
			if (linhas > 0) {	
				System.out.println("    Disciplina [ " 
								+ obj.getIdDisciplina() + " | " 
								+ obj.getNomedisciplina() + " ] "
								+ " alterado com sucesso!");
			}
			else {
				System.out.println("    Não foi realizada a alteração da Disciplina!");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.fechaPreparedStatement(pst);
		}
		
	}

	@Override
	public void excluirPorId(Integer id) {
		PreparedStatement pst = null;
		try {
			String SQL;
			SQL="delete from disciplina where iddisciplina=?";
			pst = conexao.prepareStatement(SQL);
			pst.setInt(1, id);
			
			int linhas = pst.executeUpdate();
			if (linhas > 0) {	
				System.out.println("    Disciplina [" + id + "] excluída com sucesso!");
			}
			else {
				System.out.println("    Não foi possível excluir o Disciplina id[" + id + "] !");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.fechaPreparedStatement(pst);
		}
	}

	@Override
	public Disciplina buscaPorId(Integer id) {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String SQL;
			SQL="select * from disciplina where iddisciplina=?";
			pst = conexao.prepareStatement(SQL);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				Disciplina d = new Disciplina();
				d.setIdDisciplina(rs.getInt(0));
				d.setNomedisciplina(rs.getString(1));
				d.setCargahoraria(rs.getInt(2));
				
				return d;
			}
			return null;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}		
		return null;
	}

	@Override
	public List<Disciplina> buscarTodos() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Disciplina> lista = new ArrayList<>();	
		
		try {
			String SQL;
			SQL="select * from disciplina";
			pst = conexao.prepareStatement(SQL);
			rs = pst.executeQuery();
			while (rs.next()) {   
				Disciplina d = new Disciplina(rs.getInt("iddisciplina"), rs.getString("nomedisciplina"), rs.getInt("cargahoraria"));
				lista.add(d);
			}
		}
		catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			DB.fechaPreparedStatement(pst);
			DB.fechaResultSet(rs);
		}
		return lista;	
	}

	

}
