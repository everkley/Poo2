package entities.enums;

public enum Cargo {

	DIRETOR("DIRETOR"), ANALISTA("ANALISTA"), ASSESSOR("ASSESSOR"), TECNICO("TECNICO"), ADMINISTRATIVO("ADMINISTRATIVO");

	private  String descricao;

	Cargo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
