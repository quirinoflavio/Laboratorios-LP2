package lab4;

import java.util.HashSet;

/**
 * Classe responsavel por representar o Grupo.
 * @author flaviorpqf
 *
 */
public class Grupo {
	private HashSet<Aluno> listaDeAlunos;
	private String nome;
	
	/**
	 * construtor da classe Grupo.
	 * @param nomeGrupo eh o nome do grupo a ser criado.
	 */
	public Grupo(String nomeGrupo) {
		checaNome(nomeGrupo);
		this.listaDeAlunos = new HashSet<>();
		this.nome = nomeGrupo;
	}
	
	/**
	 * Gera o nome do grupo.
	 * @return retorna uma string com o nome do grupo.
	 */
	public String getNomeGrupo() {
		return this.nome;
	}
	
	/**
	 * Adiciona o aluno passado como paramentro no grupo.
	 * @param aluno eh o aluno
	 * @return retorna um boolean confirmando ou nao a acao.
	 */
	public boolean adicionarAluno(Aluno aluno) {
		return this.listaDeAlunos.add(aluno);
	}
	
	/**
	 * Gera uma string contendo uma lista com os alunos daquele grupo.
	 * @return retorna uma string com os nomes dos alunos do grupo
	 */
	public String imprimirAlunosGrupo() {
		String saida = "Alunos do grupo " + this.nome + ":\n";
		for (Aluno aluno : this.listaDeAlunos) {
			saida += "* " + aluno + "\n";
		}
		return saida;
	}
	
	/**
	 * Verifica se o nome passado como paramentro eh nulo ou vazio.
	 * @param nome eh o nome a ser verificado.
	 */
	public void checaNome(String nome) {
		if (nome.trim().equals("") || nome == null) {
			throw new NullPointerException("Nome vazio ou nulo.");
		}
	}
	
}
