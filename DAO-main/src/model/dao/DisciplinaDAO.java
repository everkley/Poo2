package model.dao;

import java.util.List;

import model.entities.Disciplina;

public interface DisciplinaDAO {
	
	void inserir(Disciplina obj);
	void alterar(Disciplina obj);
	void excluirPorId(Integer id);
	Disciplina buscaPorId(Integer id);
	List<Disciplina> buscarTodos();

}
