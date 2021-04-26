package entities.enums;

public enum Status {

	PENDENTE("PENDENTE"), CONTRATADO("CONTRATADO"), DEMITIDO("DEMITIDO");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
