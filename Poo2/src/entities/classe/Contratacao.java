package entities.classe;

import java.util.Date;
import entities.enums.Cargo;
import entities.enums.Status;

public class Contratacao {
	private Date dataI;
	private Cargo cargo;
	private Status status;
	private Funcionario funcionario;
	private Projeto projeto;
	public Contratacao(Date dataI, Cargo cargo, Funcionario funcionario,Projeto projeto) {
		this.dataI = dataI;
		this.cargo = cargo;
		this.funcionario = funcionario;
		this.projeto = projeto;
		this.status = Status.PENDENTE;
		projeto.adicionarContratação(this);
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Projeto getProjeto() {
		return projeto;
	}


	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}


	public Date getDataI() {
		return dataI;
	}

	public void setDataI(Date dataI) {
		this.dataI = dataI;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void contratar() {
		this.status = status.CONTRATADO;
	}
	public void demitir() {
		this.status = status.DEMITIDO;
		projeto.removerContratacao(this);
	}

	public Status getStatus() {
		return status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataI == null) ? 0 : dataI.hashCode());
		result = prime * result + ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((projeto == null) ? 0 : projeto.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contratacao other = (Contratacao) obj;
		if (cargo != other.cargo)
			return false;
		if (dataI == null) {
			if (other.dataI != null)
				return false;
		} else if (!dataI.equals(other.dataI))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (projeto == null) {
			if (other.projeto != null)
				return false;
		} else if (!projeto.equals(other.projeto))
			return false;
		if (status != other.status)
			return false;
		return true;
	}



}
