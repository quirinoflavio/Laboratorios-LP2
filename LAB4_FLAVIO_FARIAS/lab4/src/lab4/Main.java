package lab4;

import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controle controle = new Controle();
		String opcao, entrada, matricula, nome, curso, nomeGrupo;
		do {
			System.out.print(exibirMenu());
			opcao = sc.nextLine().toLowerCase();
			
			switch (opcao) {
			
			case "c":
				System.out.print("Matricula: ");
				matricula = sc.nextLine();
				
				System.out.print("Nome: ");
				nome = sc.nextLine();
				
				System.out.print("Curso: ");
				curso = sc.nextLine();
				
				if(controle.cadastrarAluno(matricula, nome, curso)) {
					System.out.println("ALUNO CADASTRADO!\n");
				}
				else {
					System.out.println("Aluno já cadastrado.\n");
				}
				break;
			
			case "e":
				System.out.print("Matrícula: ");
				matricula = sc.nextLine();
				
				if (controle.existeAluno(matricula)){
					System.out.println("Aluno: " + controle.exibirAluno(matricula));
				}else {
					System.out.println("Aluno não cadastrado.\n");
				}
				break;
			
			case "n":
				System.out.print("Grupo: ");
				nomeGrupo = sc.nextLine();
				
				if (controle.criarGrupo(nomeGrupo)) {
					System.out.println("CADASTRO REALIZADO!\n");
				}else {
					System.out.println("Grupo já cadastrado.\n");
				}
				
				break;
				
			case "a":
				System.out.print("(A)locar Aluno ou (I)mprimir Grupo? ");
				entrada = sc.nextLine().toLowerCase();
				
				switch (entrada) {
				case "a":
					System.out.print("Matrícula: ");
					matricula = sc.nextLine();
					System.out.print("GRUPO: ");
					nomeGrupo = sc.nextLine();
					if(!controle.existeAluno(matricula)) {
						System.out.println("Aluno não cadastrado.\n");
					}else if(!controle.existeGrupo(nomeGrupo)) {
						System.out.println("Grupo não cadastrado.\n");
					}else {
						controle.alocarAluno(matricula, nomeGrupo);
						System.out.println("ALUNO ALOCADO!\n");
					}
					break;
				case "i" :
					System.out.print("Grupo: ");
					nomeGrupo = sc.nextLine();	
					if(controle.existeGrupo(nomeGrupo)){
						System.out.println(controle.imprimirGrupo(nomeGrupo));
					}else {
						System.out.println("Grupo não cadastrado.");
					}
				}
				break;
				
			case "r":
				System.out.print("Matrícula: ");
				matricula = sc.nextLine();
				
				if(controle.existeAluno(matricula)) {
					controle.registrarAlunoQueResponde(matricula);
					System.out.println("Aluno registrado.\n");
				}else {
					System.out.println("Aluno não registrado.\n");
				}
				break;
				
			case "i":
				System.out.println(controle.imprimirAlunosQueRespondem());
				break;
				
			case "o":
				break;
				
			default:
				checaOpcao(opcao);
				System.out.println("Opção inválida.");
			}
		}while(!opcao.equals("o"));
	}


	public static String exibirMenu() {
		String meuMenu = "(C)adastrar Aluno\n" + 
				"(E)xibir Aluno\n" + 
				"(N)ovo Grupo\n" + 
				"(A)locar Aluno no Grupo e Imprimir Grupos\n" + 
				"(R)egistrar Resposta de Aluno\n" + 
				"(I)mprimir Alunos que Responderam\n" + 
				"(O)ra, vamos fechar o programa!\n" + 
				"\n" +
				"Opção> ";
		return meuMenu;
	}
	
	public static void checaOpcao(String opcao) {
		if (opcao.trim().equals("") || opcao == null) {
			throw new NullPointerException("Opção nula ou vazia.");
		}
	}
}
