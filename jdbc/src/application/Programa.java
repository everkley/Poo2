package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import entities.Aluno;
import jdbc.AlunoJDBC;

public class Programa {

	public static void main(String[] args) {

		try {

			int opcao = 0;
			Scanner console = new Scanner(System.in);

			do {
				System.out.print("######## Menu ########" + "\n1- Cadastrar" + "\n2- Listar" + "\n3- Alterar"
						+ "\n4- Excluir" + "\n5- Sair");
				System.out.print("\n\tOpção: ");
				opcao = Integer.parseInt(console.nextLine());
				System.out.println("\n\n\n\n");

				if (opcao == 1) {

					Aluno a = new Aluno();
					AlunoJDBC acao = new AlunoJDBC();

					System.out.print("\n*** Cadastrar Aluno ***\n\r");
					System.out.print("Nome: ");
					a.setNome(console.nextLine());
					System.out.print("Sexo: ");
					a.setSexo(console.nextLine());
					System.out.print("Data de nascimento: ");
					a.setDt_nasc(new Date(console.nextLine()));

					acao.salvar(a);
					console.nextLine();
					System.out.println("\n\n\n\n");
				}
				if (opcao == 2) {
					// List alunos = new ArrayList<Aluno>();
					AlunoJDBC aluno = new AlunoJDBC();
					// alunos.add(acao.listar());
					System.out.println(aluno.listar());
				}
				if (opcao == 3) {
					AlunoJDBC aluno = new AlunoJDBC();
					Aluno aux = new Aluno();
					System.out.println("Alterar Dados");
					System.out.println("Informe o ID do Aluno");
					aux.setId(Integer.parseInt(console.nextLine()));
					System.out.print("Nome: ");
					aux.setNome(console.nextLine());
					System.out.print("Sexo: ");
					aux.setSexo(console.nextLine());
					System.out.print("Data de nascimento: ");
					aux.setDt_nasc(new Date(console.nextLine()));
					aluno.alterar(aux);
				}
				if (opcao == 4) {
					AlunoJDBC aluno = new AlunoJDBC();
					System.out.println("Exclusão por ID");
					System.out.print("Excluir aluno com ID = ");
					aluno.apagar(Integer.parseInt(console.nextLine()));
				}
			} while (opcao != 5);
		} catch (Exception e) {
			System.out.println("Erro: " + e);
		}
	}
}
