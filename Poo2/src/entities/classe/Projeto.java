package entities.classe;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Projeto {

	private String nome;
	private Date dt_Inicio;
	private Date dt_Termino;
	private List<Contratacao> listaContratacao = new ArrayList<>();

	public Projeto(String nome, Date dt_Inicio, Date dt_Termino) {

		this.nome = nome;
		this.dt_Inicio = dt_Inicio;
		this.dt_Termino = dt_Termino;
	}

	public boolean adicionarContratação(Contratacao contratacao) {

		if (contratacao != null && !listaContratacao.contains(contratacao)) {
			this.listaContratacao.add(contratacao);
			return true;
		}
		return false;
	}

	public boolean removerContratacao(Contratacao contratacao) {

		if (contratacao != null && listaContratacao.size() > 0 && listaContratacao.contains(contratacao)) {
			this.listaContratacao.remove(contratacao);
			return true;
		}
		return false;
	}
	public void listarContratacao() {
		System.out.println("***Contratações***");
		if (listaContratacao.isEmpty()) {
			System.out.println("Projeto:\n" + "\t" + this.nome);
			System.out.println("Funcionario(s):");
			for (Contratacao C : this.listaContratacao) {
				System.out.println("\t"+C.getFuncionario().getNome() + " Status: " + C.getStatus());
			}
		} else {
			System.out.println("Projeto:\n" + "\t" + this.nome);
			System.out.println("Funcionario(s):");
			for (Contratacao C : this.listaContratacao) {
				System.out.println("\t"+C.getFuncionario().getNome() + " Status: " + C.getStatus());
			}
		}
	}

}
