package lab3;

import java.util.Scanner;

/**
 * Classe principal.
 * @author Flavio Farias
 *
 */
public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		exibirMenu();
		
	}

	/**
	 * Classe para exibir o menu.
	 */
	private static void exibirMenu() {
		String opcao;
		Agenda agenda = new Agenda();
		
		do {
			System.out.println("(C)adastrar Contato");
			System.out.println("(L)istar Contatos");
			System.out.println("(E)xibir Contato");
			System.out.println("(S)air\n");
			System.out.print("Opção> ");
			opcao = sc.nextLine().toUpperCase();
			
			switch(opcao) {
			
			case "C":
				fCadastra(sc, agenda);
				break;
			
			case "L":
				fListar(agenda);
				break;
			
			case "E":
				fExibir(agenda);
				break;
			
			case "S":
				break;
			
			default:
				System.out.println("OPÇÃO INVÁLIDA\n");
			}
		}while (!opcao.equals("S"));
	}

	/**
	 * Recebe a posicao do contato na agenda e chama a funcao exibirContato(posicao).
	 * 
	 * @param agenda é a agenda de contatos.
	 */
	private static void fExibir( Agenda agenda) {
		System.out.print("Contato> ");
		int posicao = sc.nextInt();
		sc.nextLine();
		System.out.println("");
		System.out.println(agenda.exibirContato(posicao));
	}


	/**
	 * Chama a funcao da agenda para listar contatos.
	 * 
	 * @param agenda é a agenda de contatos.
	 */
	private static void fListar(Agenda agenda) {
		System.out.print("\n" + agenda.listarContato() + "\n");
	}


	/**
	 * Recebe nome, sobrenome e telefone e cadastra o contato.
	 * 
	 * @param sc2 recebe a entrada.
	 * @param agenda é a agenda de contatos.
	 */
	private static void fCadastra(Scanner sc2, Agenda agenda) {
		System.out.println("Cadastrar Contato");
		System.out.print("Posição: ");
		int posicao = sc.nextInt();
		sc.nextLine();
		if (!(1<=posicao && posicao<=100)) {
			System.out.println("POSIÇÃO INVÁLIDA!\n");
		} else {
			try {
			System.out.print("Nome: ");
			String nome = sc.nextLine();
			System.out.print("Sobrenome: ");
			String sobrenome = sc.nextLine();
			System.out.print("Telefone: ");
			String telefone = sc.nextLine();
			agenda.cadastrarContato(posicao, nome, sobrenome, telefone);
			System.out.println("CADASTRO REALIZADO!\n");
			}catch(IllegalArgumentException erro) {
				System.out.println("\nCadastro não realizado (Entrada Inválida)\n");
			}
			
			}
	}
}
