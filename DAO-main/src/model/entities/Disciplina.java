package model.entities;

public class Disciplina {
	int IdDisciplina;
	String nomedisciplina;
	int cargahoraria;

	public Disciplina() {
		
	}
	public Disciplina(int idDisciplina, String nomedisciplina, int cargahoraria) {
		IdDisciplina = idDisciplina;
		this.nomedisciplina = nomedisciplina;
		this.cargahoraria = cargahoraria;
	}

	public int getIdDisciplina() {
		return IdDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		IdDisciplina = idDisciplina;
	}

	public String getNomedisciplina() {
		return nomedisciplina;
	}

	public void setNomedisciplina(String nomedisciplina) {
		this.nomedisciplina = nomedisciplina;
	}

	public int getCargahoraria() {
		return cargahoraria;
	}

	public void setCargahoraria(int cargahoraria) {
		this.cargahoraria = cargahoraria;
	}

	@Override
	public String toString() {
		return "Disciplina [IdDisciplina=" + IdDisciplina + ", nomedisciplina=" + nomedisciplina + ", cargahoraria="
				+ cargahoraria + "]";
	}

}
